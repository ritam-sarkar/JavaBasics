/**
 * 
 */
package com.ibm.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ritam
 *
 */
public class CustomBlockingQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class CustomBlockingQueue<T> implements BlockingQueue<T>{
	
	/** The queued items */
    final Object[] items;

    /** items index for next take, poll, peek or remove */
    int takeIndex;

    /** items index for next put, offer, or add */
    int putIndex;

    /** Number of elements in the queue */
    int count;

    /*
     * Concurrency control uses the classic two-condition algorithm
     * found in any textbook.
     */

    /** Main lock guarding all access */
    final ReentrantLock lock;

    /** Condition for waiting takes */
    private final Condition notEmpty;

    /** Condition for waiting puts */
    private final Condition notFull;
    
    /**
     * 
     * @param capacity
     */
    public CustomBlockingQueue(int capacity){
    	this(capacity, false);
    }
    
    /**
     * 
     * @param capacity
     * @param fair
     */
    public CustomBlockingQueue(int capacity,boolean fair){
    	if(capacity <=0)
    		throw new IllegalArgumentException("Capacity cannot be less than 0");
    	this.lock = new ReentrantLock(fair);
    	notEmpty = lock.newCondition();
    	notFull = lock.newCondition();
    	items = new Object[capacity];
    }

    private void enqueue(T x) {

    	Object[] items = this.items;
    	items[putIndex] = x;
    	if(++putIndex ==  items.length)
    		putIndex = 0;
    	count++;
    	notFull.signalAll();    	
	}
    private T dequeue(){
    	T result = (T) items[takeIndex];
    	items[takeIndex] = null;
    	if(++takeIndex ==  items.length)
    		takeIndex = 0;
    	count--;
    	notEmpty.signalAll();  
    	return result;
    }
    /**
     * Throws NullPointerException if argument is null.
     *
     * @param v the element
     */
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }
    
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return (count == 0) ? null : dequeue();
        } finally {
            lock.unlock();
        }
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {		
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put(T e) throws InterruptedException {
		ReentrantLock lock = this.lock;
		lock.lockInterruptibly();
		try{
			checkNotNull(e);
			while(count == items.length){
				notEmpty.await();
			}
			enqueue(e);
		}finally{
			lock.unlock();
		}	
	}

	@Override
	public boolean offer(T e, long timeout, TimeUnit unit) throws InterruptedException {
		ReentrantLock lock = this.lock;
		checkNotNull(e);
		lock.lockInterruptibly();
		try{
			if(timeout<=0)
				throw new IllegalArgumentException("timeout should be greater than 0");
			while(count == items.length){
				notEmpty.await(timeout, unit);
			}
			enqueue(e);
			return true;
		}finally{
			lock.unlock();
		}
	}

	@Override
	public T take() throws InterruptedException {
		ReentrantLock lock = this.lock;
		T result = null;
		lock.lockInterruptibly();
		try{
			while(count == 0){
				notFull.await();
			}
			result = dequeue();			
		}finally{
			lock.unlock();
		}
		return result;
	}

	@Override
	public T poll(long timeout, TimeUnit unit) throws InterruptedException {
		ReentrantLock lock = this.lock;
		T result = null;
		lock.lockInterruptibly();
		try{
			while(count == 0){
				notFull.await(timeout, unit);
			}
			result = dequeue();			
		}finally{
			lock.unlock();
		}
		return result;
	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super T> c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super T> c, int maxElements) {
		// TODO Auto-generated method stub
		return 0;
	}

}
