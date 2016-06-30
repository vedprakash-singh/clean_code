package tests.suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner
{
	public static void main(String[] args)
	{
		Result results = JUnitCore.runClasses(AllTests.class);
		
		for (Failure f : results.getFailures())
			System.out.println(f.getMessage());
		
		System.out.println("\n>>> Test Statistics: Tests ran=" + results.getRunCount() + 
				", Failures=" + results.getFailureCount() + ", Skipped=" + results.getIgnoreCount());
		
		System.out.println(">>> Run time: " + results.getRunTime()/(float)1000 + " secs");
	}
}
