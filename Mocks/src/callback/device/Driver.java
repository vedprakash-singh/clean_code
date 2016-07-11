package callback.device;

public class Driver implements DeviceListener
{
	public static void main(String[] args)
	{
		Device d = new Device("test_device", new Driver());
		
		d.shutdown(new ShutdownEvent(d.getClass().getName()));
	}

	@Override
	public void shutdownInitiated(ShutdownEvent e)
	{
		System.out.println(getClass().getName() + "-> Source: " + e.getSource());
	}

	@Override
	public void shutdownComplete(ShutdownEvent e)
	{
		System.out.println(getClass().getName() + "-> Exit code: " + e.getExitCode());
	}
}
