package callback;

public class DeviceController
{
	protected DeviceListener dl = null;
	
	public DeviceController(DeviceListener dl)
	{
		this.dl = dl;
	}
	
	public void shutdown(ShutdownEvent e)
	{
		dl.triggerShutdown(e);
	}
	
	public boolean isDeviceRunning()
	{ return dl.isDeviceRunning(); }
	public static void main(String[] args)
	{
		DeviceController dc = new DeviceController(new Device());
		
		dc.shutdown(new ShutdownEvent(dc.getClass().getName(), new Integer(1000)));
	}
	
}
