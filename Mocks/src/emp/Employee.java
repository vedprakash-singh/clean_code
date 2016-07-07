package emp;

public class Employee 
{
	protected ContactInfo contact = null;
	protected String ID = null;
	protected String dept = null;

	public Employee(String ID, String dept, ContactInfo contact)
	{
		this.contact = contact;
		this.ID = ID;
		this.dept = dept;
	}
}

