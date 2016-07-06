package callback;

/**
 * Dummy implementation to show the usage of the interface.
 * @author prithvi
 *
 */
public class DeviceListenerImpl implements DeviceListener
{
	@Override
	public void shutdownInitiated(ShutdownEvent e)
	{
		System.out.println("[" + getClass().getName() + "] " 
					+ e.toString() + " Shutdown initiated");
	}


	@Override
	public void shutdownComplete()
	{
		System.out.println("[" + getClass().getName() + "] " 
				+"Shutdown completed.");
	}
}
