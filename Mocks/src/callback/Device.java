package callback;

/**
 * Arbitrary device.
 * @author prithvi
 *
 */
public class Device
{
	protected String name = null;
	protected DeviceListener dl;
	
	public Device(String name, DeviceListener dl)
	{
		this.name = name;
		this.dl = dl;
	}

	public void shutdown(ShutdownEvent e)
	{
		System.out.println("[" + getClass().getName() + "] " 
				+ toString()
				+ " -> Initiating shutdown....");
		
		dl.shutdownInitiated(e);
		
		// code for shutdown.
		
		System.out.println("[" + getClass().getName() + "] " 
				+ toString()
				+ " -> Shutdown completed.");
		
		dl.shutdownComplete();
	}

	public boolean isDeviceRunning()
	{ return true; }

	@Override
	public String toString()
	{ return "** Device [name=" + name + "] **"; }
	
}
