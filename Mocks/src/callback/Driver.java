package callback;

public class Driver
{
	public static void main(String[] args)
	{
		Device d = new Device("test_device", new DeviceListenerImpl());
		
		d.shutdown(new ShutdownEvent(d.getClass().getName(), new Integer(1000)));
	}
}
