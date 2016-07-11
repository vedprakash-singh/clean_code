package test.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import crm.Customer;
import crm.CustomerDAOImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = { TestCustomerDAO.class, CustomerDAOImpl.class })
public class TestCustomerDAO
{
	// Mocks for SQL classes and java.util.Properties.
	@Mock
	private PreparedStatement ps;
	@Mock
	private ResultSet rs;
	@Mock
	private SQLException sqlException;
	@Mock
	private Connection conn;
	@Mock
	private Properties p;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		try 
		{
			PowerMockito.whenNew(Properties.class)
				.withAnyArguments()
				.thenReturn(p);
			
			PowerMockito.mockStatic(DriverManager.class);

			PowerMockito
				.when(DriverManager.getConnection(
						Mockito.anyString(), 
						Mockito.eq(p)))
				.thenReturn(conn);

			PowerMockito
				.when(conn.prepareStatement(Mockito.anyString()))
				.thenReturn(ps);

			PowerMockito
				.when(ps.executeQuery())
				.thenReturn(rs);

			PowerMockito
				.when(rs.next())
				.thenReturn(true)
				.thenReturn(false);

			PowerMockito
				.when(rs.getString(Mockito.anyInt()))
				.thenReturn("1000")
				.thenReturn("Fisherman");

			PowerMockito
				.when(p.getProperty(Mockito.anyString()))
				.thenReturn(Mockito.anyString());

		}
		catch (Exception e) 
		{ e.printStackTrace(); }
	}

	@Test
	public void testFindCustomerByID()
	{
		Customer c = new CustomerDAOImpl(p).getByID(1000);

		Assert.assertEquals(c.getID(), "1000");
		Assert.assertEquals(c.getName(), "Fisherman");
	}
}
