package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<E> implements Iterable<E>
{
	protected E[] data = null;
	protected int stack_pointer = 0;
	
	@SuppressWarnings("unchecked")
	public MyStack(int capacity)
	{ data = (E[]) new Object[capacity]; }
	
	public void push(E element)
	{
		if (stack_pointer == data.length)
			throw new MyStackException("Stack overflow.");
		data[stack_pointer++] = element;
	}
	
	public boolean isEmpty()
	{ return stack_pointer == 0; }
	
	public int size()
	{ return stack_pointer; }

	public E pop()
	{
		if (stack_pointer == 0)
			throw new MyStackException("Stack underflow.");
		
		E element = data[--stack_pointer];
		
		data[stack_pointer] = null;
		
		return element;
	}
	
	@Override
	public Iterator<E> iterator() 
	{		
		return new Iterator<E>()
		{
			private int i = 0;
			
			@Override
			public E next()
			{
				if (i > stack_pointer - 1)
					throw new NoSuchElementException("No element to retrieve.");
				return data[i++];
			}

			@Override
			public void remove() 
			{ throw new UnsupportedOperationException("Operation not supported."); }

			@Override
			public boolean hasNext() 
			{ return i < stack_pointer; }
		};
	}
}
