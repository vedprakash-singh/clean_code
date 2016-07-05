package mocks.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import callback.DeviceController;
import callback.ShutdownEvent;
import callback.DeviceListener;

@RunWith(PowerMockRunner.class)
public class TestDeviceController
{
	/**
	 * Testing the callback.DeviceController class by mocking
	 * callback.Devicelistener and callback.ShutdownEvent.  
	 */
	@Test
	public void testShutdown()
	{
		ShutdownEvent e = PowerMockito.mock(ShutdownEvent.class);
		DeviceListener dl = PowerMockito.mock(DeviceListener.class);

		/**
		 * When the listener method triggerShutdown(...) is invoked 
		 * the code inside the doAnswer(...) is triggered.
		 */
		PowerMockito.doAnswer(new Answer<Object>()
		{
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable
			{
				System.out.println("Shutdown listener is invoked...");
				return null;
			}
		}).when(dl).triggerShutdown(e);
		
		// Call on the actual object
		DeviceController dc = new DeviceController(dl);
		dc.shutdown(e);
		
		// Verifying the call on the mock method 
		Mockito.verify(dl).triggerShutdown(e);
	}
	
	@Test
	public void testIsDeviceRunning()
	{
		DeviceListener dl = PowerMockito.mock(DeviceListener.class);
		ShutdownEvent e = PowerMockito.mock(ShutdownEvent.class);
		
		/**
		 * When the listener method isDeviceRunning(...) is invoked 
		 * the code inside the doAnswer(...) is triggered.
		 */
		PowerMockito.doAnswer(new Answer<Boolean>()
		{
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable
			{
				System.out.println("Device is running...");
				// Simulates a running device...
				return new Boolean(true);
			}
		}).when(dl).isDeviceRunning();
		
		DeviceController dc = new DeviceController(dl);
		
		// Calls to actual object
		if (dc.isDeviceRunning())
			dc.shutdown(e);
		
		// Verifying calls on the mock objects.
		Mockito.verify(dl).triggerShutdown(e);
		Mockito.verify(dl).isDeviceRunning();
	}
}
