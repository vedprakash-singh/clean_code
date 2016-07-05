package consultant;

import java.util.ArrayList;

public class Consultant 
{
	protected ContactInfo contact;
	protected ArrayList<String> expertise;
	
	public Consultant(ContactInfo contact, ArrayList<String> expertise)
	{
		this.contact = contact;
		this.expertise = expertise;
	}
}

