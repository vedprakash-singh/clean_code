package callback;

public interface DeviceListener
{
	/**
	 * Callback for device shutdown initiation.
	 * @param e Shutdown event object
	 */
	public void shutdownInitiated(ShutdownEvent e);
	
	/**
	 * Callback on shutdown completion.
	 */
	public void shutdownComplete();
}
