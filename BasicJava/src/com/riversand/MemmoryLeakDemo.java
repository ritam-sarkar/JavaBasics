package com.riversand;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MemmoryLeakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyStack stack = new MyStack();
		stack.push(new Integer(2));
		stack.push(new Integer(12));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	static class MyStack {


	    private Object[] elements;

	    private int size = 0;

	    private static final int DEFAULT_INITIAL_CAPACITY = 16;



	    public MyStack() {

	        elements = new Object[DEFAULT_INITIAL_CAPACITY];

	    }



	    public void push(Object e) {

	        ensureCapacity();

	        elements[size++] = e;

	    }



	    public Object pop() {

	        if (size == 0)

	            throw new EmptyStackException();

	        Object result =  elements[--size];
	        // This is to nullyfy the inactive reference for avoiding memmory leak
	        //elements[size] = null;
	        
	        return result;

	    }



	    /**

	     * Ensure space for at least one more element, roughly

	     * doubling the capacity each time the array needs to grow.

	     */

	    private void ensureCapacity() {

	        if (elements.length == size)

	            elements = Arrays.copyOf(elements, 2 * size + 1);

	    }
	}
}
