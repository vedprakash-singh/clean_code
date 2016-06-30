package tests.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith (Suite.class)
@SuiteClasses (
		{
			tests.TestMathUtils.class,
			tests.timed.TestAlgorithms.class,
			tests.timed.TestAlgorithmsWithRule.class,
			tests.parameterized.TestAlgorithmsParameterized.class,
			tests.parameterized.TestMathUtilsParameterized.class,
			tests.exceptions.TestWithTryCatch.class,
			tests.exceptions.TestWithExpectedParam.class,
			tests.exceptions.TestWithExpectedExceptionRule.class
		})
public class AllTests
{}
