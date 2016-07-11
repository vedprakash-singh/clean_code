package callback.device;

public class ShutdownEvent
{
	/**
	 * Source from where the shutdown event was initiated.
	 * 
	 */
	protected String source = null;
	/**
	 * System exit code.
	 * This code is set by the Device.
	 */
	protected Integer exitCode = null;
	
	// Source can only be set during construction
	public ShutdownEvent(String source)
	{ this.source = source; }
	
	public String getSource()
	{ return source; }
	
	public void setExitCode(Integer exitCode)
	{ this.exitCode = exitCode; }
	
	public Integer getExitCode()
	{ return exitCode; }

	@Override
	public String toString()
	{
		return "** ShutdownEvent [source=" + source + ", exitCode=" + exitCode + "] **";
	}
}
