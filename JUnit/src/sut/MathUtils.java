package sut;

public class MathUtils
{
	public static Integer add(Integer [] numbers)
	{
		int sum = 0;
		for (int n : numbers)
			sum += n;
			
		return sum;
	}
	
	public static Integer subtract(Integer [] numbers) 
	{ throw new UnsupportedOperationException("Method not implemented...developer has gone fishing."); }

	public static float divide(float dividend, float divisor)
	{
		if (divisor == 0)
			throw new ArithmeticException("Cannot divide by zero.");
		
		return dividend/divisor;
	}
}
