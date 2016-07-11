package crm;

public class Customer
{
	protected String ID = null;
	protected String name = null;
	
	public Customer(String ID, String name)
	{
		this.ID = ID;
		this.name = name;
	}

	public Customer() {}

	public String getID()
	{ return ID; }

	public void setID(String ID)
	{ this.ID = ID; }

	public String getName()
	{ return name; }

	public void setName(String name)
	{ this.name = name; }
	
	
}
