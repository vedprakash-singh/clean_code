package mocks.test;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import stack.MyStack;
import stack.MyStackException;

@RunWith(PowerMockRunner.class)
public class TestMyStack
{
	// General JUnit rule for exception
	@Rule
	public ExpectedException stackException = ExpectedException.none();

	/**
	 * Testing general behaviour verification with when...then* constructs
	 */
	@Test
	public void testBehaviour()
	{
		MyStack<Integer> s = PowerMockito.mock(MyStack.class);

		PowerMockito.when(s.size()).thenReturn(0);

		Assert.assertEquals(s.size(), 0);

		/**
		 * Calling mock method actually does not 
		 * insert data.
		 * Even though we call the push(...) 3 times,
		 * the size still remains 0.
		 */
		s.push(Mockito.anyInt());
		s.push(Mockito.anyInt());
		s.push(Mockito.anyInt());

		Assert.assertEquals(s.size(), 0);
}

	/**
	 * Verification of exception with messages.
	 */
	@Test
	public void testBehaviourWithException()
	{
		MyStack<Integer> s = PowerMockito.mock(MyStack.class);

		PowerMockito.when(s.pop()).thenThrow(
				new MyStackException("Stack underflow."));

		stackException.expect(MyStackException.class);
		/**
		 * Make sure that the hamcrest-core-1.3.jar's order of export is before
		 * junit-4.12.jar in the classpath. Else this method will result in
		 * java.lang.NoSuchMethodError.
		 */
		stackException.expectMessage("Stack underflow.");

		s.pop();
	}

	/**
	 * Verification of number of invocations.
	 */
	@Test
	public void testNumberOfInvocation()
	{
		MyStack<Integer> s = PowerMockito.mock(MyStack.class);

		s.push(Mockito.anyInt());
		s.push(Mockito.anyInt());
		s.push(Mockito.anyInt());

		Mockito.verify(s, Mockito.times(3)).push(Mockito.anyInt());
	}

	/**
	 * Verification of order of method invocations with one mock.
	 */
	@Test
	public void testOrderOfInvocation()
	{
		MyStack<Integer> s = PowerMockito.mock(MyStack.class);

		s.push(Mockito.anyInt());
		s.pop();

		InOrder inOrder = Mockito.inOrder(s);

		inOrder.verify(s).push(Mockito.anyInt());
		inOrder.verify(s).pop();
	}

	/**
	 * Verification of order of method invocations with more than one mock.
	 */
	@Test
	public void testOrderOfInvocationWithMocks()
	{
		MyStack<String> s1 = PowerMockito.mock(MyStack.class), s2 = PowerMockito
				.mock(MyStack.class);

		s1.push(Mockito.anyString());
		s2.push(Mockito.anyString());

		InOrder inOrder = Mockito.inOrder(s1, s2);

		inOrder.verify(s1).push(Mockito.anyString());
		inOrder.verify(s2).push(Mockito.anyString());
	}

	/**
	 * Test code for mocking consecutive method calls (iterator style)
	 */
	@Test
	public void testConsecutiveMethodCalls()
	{
		MyStack<String> s = PowerMockito.mock(MyStack.class);
		Iterator<String> it = PowerMockito.mock(Iterator.class);

		PowerMockito.when(s.iterator()).thenReturn(it);
		
		PowerMockito.when(s.iterator().next())
			.thenReturn("Power ")
			.thenReturn("of ")
			.thenReturn("mocks...");
		
		Assert.assertEquals("Power of mocks...", 
				s.iterator().next() + 
				s.iterator().next() + 
				s.iterator().next());
	}
}
