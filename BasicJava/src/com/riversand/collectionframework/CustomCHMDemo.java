/**
 * 
 */
package com.riversand.collectionframework;

import java.io.Serializable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class CustomCHMDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomCHMDemo demo = new CustomCHMDemo();
		ConcurrentHashMap<Integer, String> chm = demo.new ConcurrentHashMap<Integer, String>();		
		System.out.println(chm.segments);
		MyThread t1 = demo.new MyThread(chm, 1, "One", "t1");
		MyThread t2 = demo.new MyThread(chm, 2, "Two", "t2");
		MyThread t3 = demo.new MyThread(chm, 3, "Three", "t3");
		MyThread t4 = demo.new MyThread(chm, 4, "four", "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();	
		
		
		System.out.println(chm.get(3));
	}
	
	class MyThread extends Thread{
		private ConcurrentHashMap<Integer,String> chm;
		private Integer key;
		private String value;
		MyThread(ConcurrentHashMap<Integer,String> chm,Integer key,String value,String name){
			this.chm = chm;
			this.key = key;
			this.value = value;
			super.setName(name);
		}
		public void run(){
			chm.put(key, value);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" is calling get "+chm.get(key));
			
		}
	}
	class ConcurrentHashMap<K,V>{
	    /**
	     * The default initial capacity for this table,
	     * used when not otherwise specified in a constructor.
	     */
	    static final int DEFAULT_INITIAL_CAPACITY = 4;

	    /**
	     * The default load factor for this table, used when not
	     * otherwise specified in a constructor.
	     */
	    static final float DEFAULT_LOAD_FACTOR = 0.75f;

	    /**
	     * The default concurrency level for this table, used when not
	     * otherwise specified in a constructor.
	     */
	    static final int DEFAULT_CONCURRENCY_LEVEL = 2;

	    /**
	     * The maximum capacity, used if a higher value is implicitly
	     * specified by either of the constructors with arguments.  MUST
	     * be a power of two <= 1<<30 to ensure that entries are indexable
	     * using ints.
	     */
	    static final int MAXIMUM_CAPACITY = 1 << 30;	    

	    

	    /**
	     * Number of unsynchronized retries in size and containsValue
	     * methods before resorting to locking. This is used to avoid
	     * unbounded retries if tables undergo continuous modification
	     * which would make it impossible to obtain an accurate result.
	     */
	    static final int RETRIES_BEFORE_LOCK = 2;

		static final int MIN_SEGMENT_TABLE_CAPACITY = 2;

		final int segmentMask;

	    /**
	     * Shift value for indexing within segments.
	     */
	    final int segmentShift;

	    /**
	     * The segments, each of which is a specialized hash table.
	     */
	    final Segment<K,V>[] segments;
	    
	    
	    ConcurrentHashMap(){
	    	this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
	    }
	    ConcurrentHashMap(int initialCapacity,float loadFactor, int concurrencyLevel){
	    	 if (!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)
	             throw new IllegalArgumentException();	    	
	    	 int sshift = 0;
	         int ssize = 1;
	         while (ssize < concurrencyLevel) {
	             ++sshift;
	             ssize <<= 1;
	         }
	         this.segmentShift = 32 - sshift;
	         this.segmentMask = ssize - 1;
	         if (initialCapacity > MAXIMUM_CAPACITY)
	             initialCapacity = MAXIMUM_CAPACITY;
	         int c = initialCapacity / ssize;
	         if (c * ssize < initialCapacity)
	             ++c;
	         int cap = MIN_SEGMENT_TABLE_CAPACITY;
	         while (cap < c)
	             cap <<= 1;
	         Segment<K,V>[] ss = (Segment<K,V>[])new Segment[ssize];
	         for(int i=0;i<ssize ; i++){
	        	 ss[i] =  new Segment<K,V>(loadFactor, (int)(cap * loadFactor),(HashEntry<K,V>[])new HashEntry[cap]);
	         }
	         segments = ss;
	    }
	    
	    final class Segment<K,V> extends ReentrantLock implements Serializable {

	    	transient volatile HashEntry<K,V>[] table;
	    	transient private int threshold;
			private final float loadFactor;
			transient int count;
			//final int MAX_SCAN_RETRIES = Runtime.getRuntime().availableProcessors() > 1 ? 64 : 1;
			
			public Segment(float loadFactor, int threshold, HashEntry<K, V>[] hashEntries) {
				this.table = hashEntries;
				this.loadFactor = loadFactor;
	            this.threshold = threshold;
			}
			final V put(K key, int hash, V value){
				 V oldValue = null;
				     lock();					 
					 HashEntry<K,V>[] tab = table;
					 HashEntry<K,V> newEntry = new HashEntry<K,V>(hash, key, value, null);;
		             int index = getTableIndex(hash,tab.length);
		             HashEntry<K,V> e = tab[index];	 
		             if(e == null){
		            	 tab[index] = newEntry;
		             }
		             while(e != null){
		            	if(e.hash == hash && e.value.equals(value)){
		            		oldValue = e.value;
		            		e.value = value;
		            		break;
		            	}else if(e.next == null){
		            		e.next = newEntry;
		            		break;
		            	}else{
		            		e = e.next;
		            	}	            		
		             }		             
		               
		             if(++count > threshold){
		            	 // rehash(tab[index]);
		             }
		             if(isLocked()){
		            	 unlock(); 
		             }		             
				 return oldValue;				 
			}
			
	    	
	    }
	    void put(K key, V value){
	    	Segment<K,V> s;
	        if (value == null)
	            throw new NullPointerException();
	        int hash = key.hashCode();
	        int j = getSegmentIndex(segmentShift, segmentMask, hash);
	        s = segments[j];
	        s.put(key, hash, value);
	    }	    

	    V get(Object key){
	    	
	    	Segment<K,V> s; 
	        HashEntry<K,V>[] tab;
	        V result = null;
	        int h = key.hashCode();
	        int u =  getSegmentIndex(segmentShift, segmentMask, h);
	        tab = segments[u].table;
	        int tabIndex = getTableIndex(h, tab.length);
	        HashEntry<K, V> e = tab[tabIndex];
	        while(e != null){
	        	if(e.hash == h && e.key.equals(key)){
	        		result = e.value;
	        		break;
	        	}
	        	e = e.next;
	        }	        
			return result;	    	
	    }
        int getSegmentIndex(int segmentShift,int segmentMask,int hash){
        	int u =  (hash >>> segmentShift) & segmentMask;
        	return u;
		}
        int getTableIndex(int hash,int tabLen){
        	int i = (tabLen-1)&hash;
        	return i;
        }
		final class HashEntry<K,V> {
	        final int hash;
	        final K key;
	        volatile V value;
	        volatile HashEntry<K,V> next;

	        HashEntry(int hash, K key, V value, HashEntry<K,V> next) {
	            this.hash = hash;
	            this.key = key;
	            this.value = value;
	            this.next = next;
	        }
	    }		
		
	}

}
