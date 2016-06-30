package tests.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import sut.MathUtils;

public class TestWithExpectedParam
{
	@Test (expected = ArithmeticException.class)
	public void testDivide()
	{
		MathUtils.divide(6, 0);
		fail("This test should have failed...");
	}
}
