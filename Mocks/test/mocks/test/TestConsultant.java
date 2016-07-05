package mocks.test;

import java.util.ArrayList;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import consultant.Consultant;
import consultant.ContactInfo;

@RunWith(PowerMockRunner.class)
public class TestConsultant 
{
	@Mock private Consultant consultant;
	private ContactInfo contact = mock(ContactInfo.class);

	@Before
	public void setUp()
	{
		// mocking a constructor with power mock
		try 
		{
			whenNew(Consultant.class)
					.withArguments(ContactInfo.class, ArrayList.class)
					.thenReturn(consultant);

			whenNew(ContactInfo.class)
			.withArguments(String.class, String.class, String.class, String.class)
			.thenReturn(contact);		
		} 
		catch (Exception e) 
		{ e.printStackTrace(); }		
	}
	
	@Test
	public void testGetCount()
	{
//		ConsultancyService service = new ConsultancyService();
//		service.addConsultant(new Consultant(new ContactInfo("PBose", "Bangalore", "98", "42"), null));
//		
//		assertEquals(service.getCount(), 1);
	}
	
	@Test
	public void testAddConsultant()
	{
//		try 
//		{
//			ConsultancyService service = new ConsultancyService();
//			
//			// here the mock consultant and contact info are used rather than the actual classes
//			// asserts the return value to the expected number of consultants
//			assertEquals(service.addConsultant(new Consultant(new ContactInfo("PBose", "Bangalore", "98", "42"), null)), 1);
//			
//			// verifies whether constructor call happened with the specified arguments
//			//change these values and see what happens
//			verifyNew(ContactInfo.class).withArguments(new ContactInfo("PBose", "Bangalore", "98", "42"));
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
	}
}
