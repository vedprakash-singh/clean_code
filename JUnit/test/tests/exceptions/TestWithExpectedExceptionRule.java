package tests.exceptions;

import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sut.MathUtils;

public class TestWithExpectedExceptionRule
{
	@Rule
	// MUST be public
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testDivide()
	{
		expectedException.expect(ArithmeticException.class);
		expectedException.expectMessage("Cannot divide by zero.");
		
		MathUtils.divide(30, 0);
	}

	@SuppressWarnings("null")
	@Test
	public void testNullPointerException()
	{
		expectedException.expect(NullPointerException.class);
		
		Vector<String> list = null;
		list.add("Test String...");
	}
}
