package sut;

public class Algorithms
{
	public void rogueMethod()
	{ 
		while(true) {} 
	}
	
	public int notSoRogueMethod()
	{
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return 10;
	}
	
	public String reverse(String str)
	{ return new StringBuilder(str).reverse().toString(); }
}

