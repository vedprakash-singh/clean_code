package callback.device;

/**
 * Arbitrary device.
 * @author prithvi
 *
 */
public class Device
{
	protected String name = null;
	protected DeviceListener dl;
	protected boolean isRunning = true;
	
	public Device(String name, DeviceListener dl)
	{
		this.name = name;
		this.dl = dl;
	}

	public void shutdown(ShutdownEvent e)
	{
		if (!isRunning)
			return;
		
		System.out.println("[" + getClass().getName() + "] " 
				+ toString()
				+ " -> Initiating shutdown....");
		
		// Informs the device listener of the device shutdown
		dl.shutdownInitiated(e);
		
		/**
		 *  code for shutdown.
		 */
		
		System.out.println("[" + getClass().getName() + "] " 
				+ toString()
				+ " -> Shutdown completed.");
		
		e.setExitCode(1000);
		dl.shutdownComplete(e);
	}

	public boolean isDeviceRunning()
	{ return isRunning; }

	@Override
	public String toString()
	{ return "** Device [name=" + name + "] **"; }
	
}
