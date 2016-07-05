package mocks.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import stack.MyStack;
import stack.MyStackException;

/**
 * Class demostrating PowerMockito features
 * 
 * @author pbose
 *
 */
@RunWith(PowerMockRunner.class)
public class AdvancedPowerMockTest
{
	/**
	 * Test for spy objects
	 */
	@Test
	public void testSpy()
	{
		MyStack<String> s = new MyStack<String>(10);
		// Create a spy object on the real object
		MyStack<String> spy = PowerMockito.spy(s);
		
		// Actual methods are called on the spy...
		spy.push("Hi there!");
		Assert.assertEquals(spy.pop(), "Hi there!");
		
		// Verifying whether push() and pop() were called on the spies.
		Mockito.verify(spy).push(Mockito.anyString());
		Mockito.verify(spy).pop();
		
		/**
		 *  Optionally spy methods can be stubbed.
		 *  Some gotchas:
		 *  The following line of code won't work, instead use the 
		 *  do*(...) family of methods
		 *  
		 *  PowerMockito.when(spy.pop()).thenReturn("Test");
		 */
		PowerMockito.doReturn("Test").when(spy).pop();
		Assert.assertEquals(spy.pop(), "Test");
	}
	
	/**
	 * Test for doNothing()
	 */
	@Test
	public void testDoNothing()
	{
		// Stack of 2 elements
		MyStack<String> s = new MyStack<String>(2);
		// Create a spy object on the real object
		MyStack<String> spy = PowerMockito.spy(s);
		
		spy.push("One");
		spy.push("Two");
		
		/**
		 * Adding 3rd element will result in "Stack overflow." exception.
		 * With doNothing() any calls on the mock method has no effect.
		 */
		PowerMockito.doNothing().when(spy).push("Three");
		spy.push("Three");
	}
	
	/**
	 * Testing doCallRealMethod().
	 * Calls the actual MyStack.pop() that results in a 
	 * "Stack underflow." exception.
	 */
	@Test (expected = MyStackException.class)
	public void testDoCallRealMethod()
	{
		MyStack<String> s = PowerMockito.mock(MyStack.class);
		
		PowerMockito.doCallRealMethod().when(s).pop();
		
		s.pop();
	}

	/**
	 * Testing nested calls.
	 * @throws IOException
	 */
	@Test
	public void testNestedMethodCall() throws IOException
	{
		// mock PrintWriter class
		PrintWriter pwMock = PowerMockito.mock(PrintWriter.class);

		BufferedWriter bw = new BufferedWriter(pwMock);
		bw.close();
		// verify whether the close() call was made to the mocked PrintWriter
		Mockito.verify(pwMock).close();
	}
	
	/**
	 * Test interfaces 
	 */
	@Test
	public void testInterface()
	{
		List<String> l = PowerMockito.mock(List.class);
	
		PowerMockito.when(l.add("Test Interface")).thenReturn(true);
		
		Assert.assertEquals(l.add("Test Interface"), true);
	}
}
