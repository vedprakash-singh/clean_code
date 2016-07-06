package mocks.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import callback.Device;
import callback.ShutdownEvent;
import callback.DeviceListener;

@RunWith(PowerMockRunner.class)
public class TestDevice
{
	/**
	 * Testing the callbacks in callback.DeviceController class by mocking
	 * callback.Devicelistener and callback.ShutdownEvent.  
	 */
	@Test
	public void testShutdownInitiated()
	{
		ShutdownEvent e = PowerMockito.mock(ShutdownEvent.class);
		DeviceListener dl = PowerMockito.mock(DeviceListener.class);

		/**
		 * When the listener method shutdownInitiated(...) is invoked 
		 * the code inside the doAnswer(...) is triggered.
		 */
		PowerMockito.doAnswer(new Answer<Object>()
		{
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable
			{
				System.out.println("DeviceListener.shutdownInitiated called...");
				return null;
			}
		}).when(dl).shutdownInitiated(e);
		
		// Call on the actual object
		Device dc = new Device("test_device", dl);
		dc.shutdown(e);
		
		// Verifying the call on the mock method 
		Mockito.verify(dl).shutdownInitiated(e);
	}
	
	@Test
	public void testShutdownCompleted()
	{
		DeviceListener dl = PowerMockito.mock(DeviceListener.class);
		ShutdownEvent e = PowerMockito.mock(ShutdownEvent.class);
		
		/**
		 * When the listener method shutdownComplete(...) is invoked 
		 * the code inside the doAnswer(...) is triggered.
		 */
		PowerMockito.doAnswer(new Answer<Boolean>()
		{
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable
			{
				System.out.println("DeviceListener.shutdownCompleted called...");
				// Simulates a successful shutdown...
				return null;
			}
		}).when(dl).shutdownComplete();
		
		Device d = new Device("test_device", dl);
		
		// Calls to actual object
		if (d.isDeviceRunning())
			d.shutdown(e);
		
		// Verifying calls on the mock objects.
		Mockito.verify(dl).shutdownInitiated(e);
		Mockito.verify(dl).shutdownComplete();
	}
}
