package mocks.test;

import modifier.Modifiers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Tests for 
 * 	Static methods
 * 	Private methods
 * 	Constructors
 * 	Void methods 
 * 	Final methods
 * @author prithvi
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = Modifiers.class)
public class TestModifiers
{
	/**
	 * Test for mocking a static call
	 */
	@Test
	public void testStaticCall()
	{
		PowerMockito.mockStatic(Math.class);
		
		PowerMockito.when(Math.sqrt(25)).thenReturn(5.0);
		Assert.assertEquals(Math.sqrt(25), 5, 0);
		
		PowerMockito.when(Math.sqrt(6.25)).thenReturn(2.5);
		Assert.assertEquals(Math.sqrt(6.25), 2.5, 0);
	}
	
	@Test
	public void testStaticMethod1()
	{
		PowerMockito.mockStatic(Modifiers.class);
		
		PowerMockito.when(Modifiers.staticMethod()).thenReturn(true);
		Assert.assertEquals(Modifiers.staticMethod(), true);
		
		Modifiers.staticMethod();
		Modifiers.staticMethod();

		// Modifier.staticMethod() is called 3 times above
		PowerMockito.verifyStatic(Mockito.times(3));
		
		/**
		 * Need to call Modifier.staticMethod() again to make 
		 * verifyStatic work.
		 */
		Modifiers.staticMethod();
	}
	
	/**
	 * Test for mocking private methods
	 */
	@Test
	public void testPrivateMethod()
	{
		Modifiers spy = PowerMockito.spy(PowerMockito.mock(Modifiers.class));
		
		try 
		{
			/*
			 * Use when(Class, ...) to test private static methods.
			 */
			PowerMockito.doReturn(true).when(spy, "privateMethod1");

			Assert.assertEquals(spy.publicMethod1(), true);
			
			/**
			 * publicMethod() internally calls 2 private 
			 * methods, that's what we verify below.
			 */
			PowerMockito.verifyPrivate(spy).invoke("privateMethod1");
			PowerMockito.verifyPrivate(spy).invoke("privateMethod2");
		}
		catch (Exception e) 
		{ e.printStackTrace(); }
	}
	
	/**
	 * Tests for protected method
	 */
	@Test
	public void testProtectedMethod()
	{
		Modifiers spy = PowerMockito.spy(PowerMockito.mock(Modifiers.class));
		
		try 
		{
			PowerMockito.when(spy, "protectedMethod").thenReturn(true);
		}
		catch (Exception e) 
		{ e.printStackTrace(); }

		Assert.assertEquals(spy.publicMethod2(), true);
	}
	
	/**
	 * Test for constructors
	 */
	@Test
	public void testConstructor()
	{
		Modifiers m = PowerMockito.mock(Modifiers.class);
		
		try 
		{
			PowerMockito.whenNew(Modifiers.class)
				.withArguments(Mockito.anyBoolean())
				.thenReturn(m);
			
			Modifiers mod = new Modifiers(true);
			
			PowerMockito.verifyNew(Modifiers.class).withArguments(Mockito.anyBoolean());
		}
		catch (Exception e) 
		{ e.printStackTrace(); }
	}
}
