package test.callback.device;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import callback.device.Device;
import callback.device.DeviceListener;
import callback.device.ShutdownEvent;

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
		DeviceListener dl = PowerMockito.mock(DeviceListener.class);
		
		/**
		 * Use ArgumentCaptor with verification.
		 * ArgumentCaptor captures the values of mocks that is 
		 * useful for further assertions.
		 */
		ArgumentCaptor<ShutdownEvent> captor = ArgumentCaptor.forClass(ShutdownEvent.class);

		// Call on the actual object
		Device dc = new Device("test_device", dl);
		
		dc.shutdown(new ShutdownEvent(getClass().getName()));
		
		// Verifying the call on the mock method 
		Mockito.verify(dl).shutdownInitiated(captor.capture());
		//check the source of the captor
		Assert.assertEquals(captor.getValue().getSource(), getClass().getName());
		// check the exit code of the captor
		Assert.assertEquals(captor.getValue().getExitCode(), new Integer(1000));
	}
}
