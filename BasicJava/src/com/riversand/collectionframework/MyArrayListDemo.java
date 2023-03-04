package com.riversand.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListDemo {

	public static void main(String[] args) {

		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		myArrayList.add(4);
		myArrayList.add(2,5);
		myArrayList.add(null);
		System.out.println(myArrayList.get(3));
		System.out.println(myArrayList.get(6));
		System.out.println(myArrayList.size());
		System.out.println(myArrayList.remove(2));
		System.out.println(myArrayList.size());
		Iterator<Integer> itr = myArrayList.iterator();
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		itr.remove();
		System.out.println(itr.next());
		itr.remove();
		System.out.println(myArrayList.hashCode());
		//itr.remove();
		
	}
	static class MyArrayList<E>{
		
		private int size;
		private int modCount;
		private static final int defaultCapacity =10;
		private int capacity;
		private Object[] elementData;
		
		
		public MyArrayList() {
			this(defaultCapacity);
		}
		public MyArrayList(int capacity){
			this.capacity = capacity;
			elementData = new Object[capacity];			
		}
		public int size() {
			return size;
		}
		public int capacity() {
			return capacity;
		}
		public boolean isEmpty() {
			return size ==0;
		}
		public boolean add(E element) {
			ensureCapacity(size+1);
			modCount++;
			elementData[size++] = element;
			return true;			
		}
		public boolean add(int index, E element) {
			rangeCheck(index);
			ensureCapacity(size+1);
			modCount++;
			/**
			 * shift index to index+1,  and all the next values by one place to the right
			 */
			System.arraycopy(elementData, index, elementData, index+1, size-index);
			elementData[index] = element;
			size++;
			return true;
		}
		public E get(int index) {
			rangeCheck(index);
			return (E) elementData[index];
		}
		public E remove(int index) {
			rangeCheck(index);
			if(size ==0) {
				throw new IllegalArgumentException();
			}
			E element = (E) elementData[index];
			modCount++;			
			/**
			 * Shift all element  after the index by 1 place to the left
			 */
			System.arraycopy(elementData, index+1, elementData, index, size-index-1);
			elementData[--size] = null;
			return element;			
		}
		public E remove(E element) {
			int index = 0;
			for(int i=0; i< elementData.length ; i++) {
				if(element == null) {
					if(elementData[i] == element) {
						index = i;
					}
				}else {
					if(elementData[i].equals(element)) {
						index =i;
					}
				}
			}
			return remove(index);
		}
		private void rangeCheck(int index) {
			if(index > size || index < 0) {
				throw new IndexOutOfBoundsException();
			}			
		}
		private void ensureCapacity(int newCapacity) {
			if(capacity < newCapacity) {
				capacity = capacity + capacity/2;
				elementData = Arrays.copyOf(elementData, capacity);
			}
		}
		public int hashCode() {
			
			return capacity ^ 0;
			
		}
		public Iterator<E> iterator(){
			return new Itr();
		}
		private class Itr implements Iterator<E> {
 
			private int cursor;
			private int lastRet = -1;
			private int expectedModCount = modCount;
			
			@Override
			public boolean hasNext() {				
				return cursor != size;
			}

			@Override
			public E next() {
				checkForComodification();
				if(cursor >= size) {
					throw new NoSuchElementException();
				}
				lastRet = cursor;
				return (E) elementData[cursor++]; 
			}
			public void remove() {
				checkForComodification();
				if(lastRet < 0) {
					throw new IllegalStateException();
				}
				MyArrayList.this.remove(lastRet);
				cursor = lastRet;
				expectedModCount = modCount;
				lastRet = -1;
			}
			final void checkForComodification() {
	            if (modCount != expectedModCount)
	                throw new ConcurrentModificationException();
	        }
			
		}
	}

}
