package consultant;

public class ContactInfo 
{
	protected String name;
	protected String address;
	protected String mobile_phone;
	protected String fixed_line_phone;
	
	public ContactInfo(String name, String address, String mobile_phone, String fixed_line_phone)
	{
		this.name = name;
		this.address = address;
		this.mobile_phone = mobile_phone;
		this.fixed_line_phone = fixed_line_phone;
	}
	
	public String getName()
	{ return name; }
	
	public void setName(String name)
	{ this.name = name; }

	public String getAddress()
	{ return address; }
	
	public void setAddress(String address)
	{ this.address = address; }

	public String getMobile()
	{ return mobile_phone; }
	
	public void setMobile(String mobile_phone)
	{ this.mobile_phone = mobile_phone; }

	public String getFixedLine()
	{ return fixed_line_phone; }
	
	public void setFixedLine(String fixed_line_phone)
	{ this.fixed_line_phone = fixed_line_phone; }
}
