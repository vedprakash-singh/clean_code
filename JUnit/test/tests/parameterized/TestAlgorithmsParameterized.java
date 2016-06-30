package tests.parameterized;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import sut.Algorithms;

/**
 * Using public fields approach using the @Parameter
 * @author pbose
 *
 */
@RunWith(Parameterized.class)
public class TestAlgorithmsParameterized
{
	@Parameters (name = "{index}: reverse({0})={1}")
	public static Collection<Object[]> data()
	{
		Collection<Object[]> data = new ArrayList<>();
		data.add(new String [] {"Johnny", "ynnhoJ"});
		data.add(new String [] {"Pool", "looP"});
		data.add(new String [] {"river", "revir"});
		
		return data;
		
	}

	@Parameter // By default the parameter index is 0
	public String properStr; // Must be public
	
	@Parameter (value = 1)
	public String reversedStr; // Must be public 
	
	@Test
	public void testReverse()
	{
		assertEquals(reversedStr, new Algorithms().reverse(properStr));
	}

}
