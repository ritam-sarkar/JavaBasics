package com.riversand.collectionframework;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LRUCacheDemo {

    private interface LRUCache<K,V> {
        V get(K key);
        V put(K key, V v);
    }
    static LRUCache<String,String> getCache(Supplier<LRUCache> supplier){
        return supplier.get();
    }


    public static void main(String[] args) throws InterruptedException {
        // LinkedHashmap cache
       // LRUCache<String,String> lruCache = getCache(()-> new LinkedHashMapLRUCache<String,String>(2));
        LRUCache<String,String> lruCache = getCache(() -> new CustomLruCache<String,String>(2));
        lruCache.put("A","A");
        lruCache.put("B","B");
        lruCache.put("C","C");
        lruCache.put("A","A");
        // Cache has 2 elements now A, C  old values are evicted
        System.out.println(lruCache.get("A"));// A is recently used
        System.out.println(lruCache.get("B")); // as capacity is 2 , B is not there in cache
        System.out.println(lruCache.get("C")); // C is also there
        ((CustomLruCache)lruCache).printCacheState();

        System.out.println(" ------------- Time to leave lru cache  ------------------------");
        LRUCache<String,String> lruCacheTTL = getCache(() -> new LRUCacheWithTTL<String,String>(3, 3000));

        lruCacheTTL.put("1", "A");
        lruCacheTTL.put("2", "B");
        Thread.sleep(1000);
        lruCacheTTL.put("3", "C");
        Thread.sleep(2500);
        System.out.println("1 is expired "+lruCacheTTL.get("1")); // Expired
        System.out.println("3 is not expired  "+lruCacheTTL.get("3")); // Expired
        lruCacheTTL.put("4", "D"); // Evicts key 2 or 3 based on TTL/LRU

        System.out.println(lruCacheTTL.get("1")); // null
        System.out.println(lruCacheTTL.get("2")); // null or "B"
        System.out.println(lruCacheTTL.get("3")); // "C" or null
        System.out.println(lruCacheTTL.get("4")); // "D"


    }

    /**
     * Using the linked hashmap implementation is easy
     */
    private static class LinkedHashMapLRUCache<K, V> extends LinkedHashMap<K, V> implements LRUCache<K,V>{
        private final int capacity;

        public LinkedHashMapLRUCache(int capacity) {
            super(capacity, 0.75f, true); // true = access-order
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }

    }

    /**
     * design from scratch using doubly linked list
     */
    private static class CustomLruCache<K, V> implements LRUCache<K,V>{
        private final int capacity;
        private final HashMap<K, Node<K, V>> map;
        private final DoublyLinkedList<K, V> list;

        public CustomLruCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new DoublyLinkedList<>();
        }

        public V get(K key) {
            if (!map.containsKey(key)) return null;
            Node<K, V> node = map.get(key);
            list.moveToFront(node);
            return node.value;
        }

        public V put(K key, V value) {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                list.moveToFront(node);
            } else {
                if (map.size() >= capacity) {
                    Node<K, V> lru = list.removeTail();
                    if (lru != null) {
                        map.remove(lru.key);
                    }
                }
                Node<K, V> newNode = new Node<>(key, value);
                list.addToFront(newNode);
                map.put(key, newNode);
            }
            return null;
        }

        // For debugging
        public void printCacheState() {
            list.printList();
        }

        // Node class
        private static class Node<K, V> {
            K key;
            V value;
            Node<K, V> prev, next;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // Doubly Linked List
        private static class DoublyLinkedList<K, V> {
            private Node<K, V> head, tail;

            void addToFront(Node<K, V> node) {
                node.next = head;
                node.prev = null;
                if (head != null) head.prev = node;
                head = node;
                if (tail == null) tail = head;
            }

            void moveToFront(Node<K, V> node) {
                if (node == head) return;

                // Remove node
                if (node.prev != null) node.prev.next = node.next;
                if (node.next != null) node.next.prev = node.prev;
                if (node == tail) tail = node.prev;

                // Add to front
                node.prev = null;
                node.next = head;
                if (head != null) head.prev = node;
                head = node;
            }

            Node<K, V> removeTail() {
                if (tail == null) return null;
                Node<K, V> removed = tail;
                if (tail.prev != null) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    head = tail = null;
                }
                return removed;
            }

            void printList() {
                Node<K, V> current = head;
                while (current != null) {
                    System.out.print("(" + current.key + ", " + current.value + ") ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    /**
     * Design from scratch , TTL is added
     */
    private static class LRUCacheWithTTL<K, V> implements LRUCache<K,V>{
        private final int capacity;
        private final long ttlInMillis;
        private final HashMap<K, Node<K, V>> map;
        private final DoublyLinkedList<K, V> list;

        public LRUCacheWithTTL(int capacity, long ttlInMillis) {
            this.capacity = capacity;
            this.ttlInMillis = ttlInMillis;
            this.map = new HashMap<>();
            this.list = new DoublyLinkedList<>();
        }

        public synchronized V get(K key) {
            Node<K, V> node = map.get(key);
            if (node == null || isExpired(node)) {
                remove(key); // Remove expired
                return null;
            }
            list.moveToFront(node);
            return node.value;
        }

        public synchronized V put(K key, V value) {
            long now = System.currentTimeMillis();
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                node.timestamp = now;
                list.moveToFront(node);
            } else {
                if (map.size() >= capacity) {
                    evict();
                }
                Node<K, V> newNode = new Node<>(key, value, now);
                list.addToFront(newNode);
                map.put(key, newNode);
            }
            return null;
        }

        private void evict() {
            // Custom eviction logic:
            // 1. Remove expired first
            for (K key : map.keySet()) {
                Node<K, V> node = map.get(key);
                if (isExpired(node)) {
                    remove(key);
                    return;
                }
            }
            // 2. Fall back to LRU if nothing is expired
            Node<K, V> lru = list.removeTail();
            if (lru != null) {
                map.remove(lru.key);
            }
        }

        public synchronized void remove(K key) {
            Node<K, V> node = map.remove(key);
            if (node != null) {
                list.remove(node);
            }
        }

        private boolean isExpired(Node<K, V> node) {
            return (System.currentTimeMillis() - node.timestamp) >= ttlInMillis;
        }

        // ======= Internal Classes =======

        private static class Node<K, V> {
            K key;
            V value;
            long timestamp;
            Node<K, V> prev, next;

            Node(K key, V value, long timestamp) {
                this.key = key;
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        private static class DoublyLinkedList<K, V> {
            private Node<K, V> head, tail;

            void addToFront(Node<K, V> node) {
                node.next = head;
                node.prev = null;
                if (head != null) head.prev = node;
                head = node;
                if (tail == null) tail = node;
            }

            void moveToFront(Node<K, V> node) {
                if (node == head) return;
                remove(node);
                addToFront(node);
            }

            void remove(Node<K, V> node) {
                if (node.prev != null) node.prev.next = node.next;
                if (node.next != null) node.next.prev = node.prev;
                if (node == head) head = node.next;
                if (node == tail) tail = node.prev;
            }

            Node<K, V> removeTail() {
                if (tail == null) return null;
                Node<K, V> node = tail;
                remove(node);
                return node;
            }
        }
    }





}
