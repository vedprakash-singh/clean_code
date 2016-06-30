package tests.timed;

import org.junit.Test;
import static org.junit.Assert.*;

import sut.Algorithms;

public class TestAlgorithms
{
	@Test(timeout = 5000) // fail the test after 5 s
	public void testRogueMethod()
	{
		new Algorithms().rogueMethod();
	}
	
	@Test(timeout = 7000) // fail the test after 7 s
	public void testNotSoRogueMethod()
	{
		assertEquals(10, new Algorithms().notSoRogueMethod());
	}

}
