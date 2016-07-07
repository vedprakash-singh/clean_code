package modifier;

public final class Modifiers
{
	protected boolean bField = false;
	
	public Modifiers(boolean bField)
	{ this.bField = bField; }
	
	private boolean privateMethod1() 
	{ return bField; }
	
	private boolean privateMethod2() 
	{ return privateMethod1(); }
	
	public final boolean publicMethod1()
	{ return privateMethod2(); }

	protected boolean protectedMethod()
	{ return bField; }

	public final boolean publicMethod2()
	{ return protectedMethod(); }
	
	public static boolean staticMethod()
	{ return false; }
}
