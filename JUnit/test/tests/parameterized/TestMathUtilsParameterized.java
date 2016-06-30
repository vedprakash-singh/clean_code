package tests.parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import sut.MathUtils;

/**
 * Using constructor approach.
 * @author pbose
 *
 */

@RunWith(Parameterized.class)
public class TestMathUtilsParameterized
{
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(
				new Object[][] 
				{ 
						{ 3, new Integer [] {1, 2} },
						{ 15, new Integer [] {1, 2, 3, 4, 5} },
						{ 1, new Integer [] {0, 1} },
						{ 69, new Integer [] {22, 23, 24} }
				});
	}
	
	private Integer expectedResult = 0;
	private Integer[] numbersToAdd = null;

	public TestMathUtilsParameterized(Integer expectedResult, Integer [] numbersToAdd)
	{
		this.expectedResult = expectedResult;
		this.numbersToAdd = numbersToAdd;
	}
	
	@Test
	public void testAdd()
	{
		assertEquals(expectedResult, MathUtils.add(numbersToAdd));
	}
}
