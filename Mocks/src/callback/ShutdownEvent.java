package callback;

public class ShutdownEvent
{
	/**
	 * Source from where the shutdown event was initiated.
	 * 
	 */
	protected String source = null;
	/**
	 * System exit code.
	 */
	protected Integer exitCode = null;
	
	public ShutdownEvent(String source, Integer exitCode)
	{
		this.source = source;
		this.exitCode = exitCode;
	}

	@Override
	public String toString()
	{
		return "ShutdownEvent [source=" + source + ", exitCode=" + exitCode + "]";
	}
}
