package mocks.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import emp.Employee;
import emp.ContactInfo;

@RunWith(PowerMockRunner.class)
public class TestEmployee 
{
	// Create a mock at the class level using annotations
	@Mock private Employee emp;
	@Mock private ContactInfo contact;

	@Before
	public void setUp()
	{
		try 
		{
			PowerMockito.whenNew(Employee.class)
					.withArguments(Mockito.anyString(), 
							Mockito.anyString(), 
							Mockito.eq(ContactInfo.class))
					.thenReturn(emp);

			PowerMockito.whenNew(ContactInfo.class)
			.withArguments(Mockito.anyString(), 
					Mockito.anyString(), 
					Mockito.anyString())
			.thenReturn(contact);		
		} 
		catch (Exception e) 
		{ e.printStackTrace(); }		
	}
	
	@Test
	public void testAddToList()
	{
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.add(new Employee("111", "Fishing", 
				new ContactInfo("Xanadu", "9876543210", "87654321")));
		
		Assert.assertEquals(empList.size(), 1);
	}
	
	@Test
	public void testCreation()
	{
		try 
		{
			ContactInfo ci = new ContactInfo("Xanadu", "9876543210", "87654321");
			Employee e = new Employee("1234", "Boating", ci);
			
			PowerMockito.verifyNew(Employee.class)
				.withArguments(Mockito.eq("1234"), Mockito.eq("Boating"), Mockito.eq(ci));

			PowerMockito.verifyNew(ContactInfo.class)
				.withArguments(new ContactInfo("Xanadu", "9876543210", "87654321"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
