package callback;

public class Driver
{
	public static void main(String[] args)
	{
		DeviceController dc = new DeviceController(new Device());
		
		dc.shutdown(new ShutdownEvent(dc.getClass().getName(), new Integer(1000)));
	}
}
