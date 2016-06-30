package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import sut.MathUtils;

/**
 * Command line: java -cp JUnit\bin;lib\junit4.12\junit-4.12.jar;lib\junit4.12\hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.TestMathUtils
 * 
 * @author pbose
 *
 */
public class TestMathUtils
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		System.out.println("TestMathUtils.setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		System.out.println("TestMathUtils.tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception
	{
		System.out.println("TestMathUtils.setUp()");
	}

	@After
	public void tearDown() throws Exception
	{
		System.out.println("TestMathUtils.tearDown()");
	}

	@Test
	public void testAdd()
	{
		assertEquals(new Integer(15), MathUtils.add(new Integer [] {1, 2, 3, 4, 5}));
	}
	
	@Test
	@Ignore("Testers on strike...")
	public void testSubtract()
	{
		assertEquals(new Integer(3), MathUtils.subtract(new Integer [] {10, 3, 4}));
	}
}
