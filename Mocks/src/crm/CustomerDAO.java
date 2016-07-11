package crm;

import java.util.List;

public interface CustomerDAO
{
	public boolean insert(Customer c);
	public boolean update(Customer c);
	public boolean delete(Customer c);
	
	public List<Customer> getAll();
	public Customer getByID(int ID);
}
