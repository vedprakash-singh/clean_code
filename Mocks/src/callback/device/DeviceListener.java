package callback.device;

public interface DeviceListener
{
	/**
	 * Callback for device shutdown initiation.
	 * Only ShutdownEvent.source has a valid value.
	 * @param e Shutdown event object
	 */
	public void shutdownInitiated(ShutdownEvent e);
	
	/**
	 * Callback on shutdown completion.
	 * Both ShutdownEvent.source and ShutdownEvent.exitCode have 
	 * valid values.
	 * @param e Shutdown event object
	 */
	public void shutdownComplete(ShutdownEvent e);
}
