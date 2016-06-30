package tests.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.MathUtils;

public class TestWithTryCatch
{
	@Test
	public void testDivide()
	{
		try
		{
			MathUtils.divide(6, 0);
			fail("This test should have failed...");
		}
		catch(ArithmeticException ae)
		{
			assertEquals("Cannot divide by zero.", ae.getMessage());
		}
	}
}
