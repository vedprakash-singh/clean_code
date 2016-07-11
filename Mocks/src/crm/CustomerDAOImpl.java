package crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CustomerDAOImpl implements CustomerDAO
{
	private Properties p = null;
	
	public CustomerDAOImpl(Properties p)
	{
		this.p = p;
	}
	
	@Override
	public boolean insert(Customer c)
	{ return false; }

	@Override
	public boolean update(Customer c)
	{ return false; }

	@Override
	public boolean delete(Customer c)
	{ return false; }

	@Override
	public List<Customer> getAll()
	{ return null; }

	@Override
	public Customer getByID(int ID)
	{
		Customer c = new Customer();
		
		try(Connection conn = DriverManager.getConnection(p.getProperty("url"), p);)
		{
			String sqlStmt = "SELECT id, name FROM customer WHERE id = ?";
			
			try(PreparedStatement cmd = conn.prepareStatement(sqlStmt))
			{
				cmd.setInt(1, ID);
				
				try (ResultSet set = cmd.executeQuery())
				{
					while (set.next())
					{
						c.setID(set.getString(1));
						c.setName(set.getString(2));
					}
				}
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			// log the exception.
		}

		return c;
	}
}
