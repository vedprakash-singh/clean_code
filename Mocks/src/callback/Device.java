package callback;

/**
 * Arbitrary device.
 * @author prithvi
 *
 */
public class Device implements DeviceListener
{
	@Override
	public void triggerShutdown(ShutdownEvent e)
	{
		System.out.println(e.toString() + " -> Initiating shutdown.");
	}

	@Override
	public boolean isDeviceRunning()
	{
		return false;
	}
}
