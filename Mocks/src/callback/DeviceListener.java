package callback;

public interface DeviceListener
{
	/**
	 * Triggers device shutdown.
	 * @param e Shutdown event object
	 */
	public void triggerShutdown(ShutdownEvent e);
	/**
	 * Returns the state of the device.
	 * @return True for running/paused, False for stopped.
	 */
	public boolean isDeviceRunning();
}
