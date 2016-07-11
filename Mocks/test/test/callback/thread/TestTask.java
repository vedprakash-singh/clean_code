package test.callback.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import callback.thread.Task;
import callback.thread.TaskListener;

@RunWith(PowerMockRunner.class)
public class TestTask
{
	@Mock
	private TaskListener tl;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testStart()
	{
		Task t = new Task(tl);
		
		t.start();
		
		/**
		 * Use ArgumentCaptor with verification.
		 * ArgumentCaptor captures the values of mocks that is 
		 * useful for further assertions.
		 */
		ArgumentCaptor<Date> captor = ArgumentCaptor.forClass(Date.class);
		
		// Capture the values sent by the callback
		Mockito.verify(tl).onStart(captor.capture());
		
		// Assert it.
		Assert.assertEquals(
				new SimpleDateFormat("yyyy").format(captor.getValue()),
				new SimpleDateFormat("yyyy").format(new Date()));
	}
}
