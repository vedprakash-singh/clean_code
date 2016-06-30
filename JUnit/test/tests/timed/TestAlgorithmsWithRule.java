package tests.timed;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import sut.Algorithms;

public class TestAlgorithmsWithRule
{
	@Rule
	// the field MUST be public
	public Timeout timeout = Timeout.seconds(7);
	
	@Test
	public void testRogueMethod()
	{
		new Algorithms().rogueMethod();
	}
	
	@Test
	public void testNotSoRogueMethod()
	{
		assertEquals(10, new Algorithms().notSoRogueMethod());
	}

}
