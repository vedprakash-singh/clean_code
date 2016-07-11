package callback.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task implements Runnable
{
	protected TaskListener tl;
	protected Thread t;
	
	public Task(TaskListener tl)
	{ 
		this.tl = tl;
		t = new Thread(this);
	}
	
	public void start()
	{ t.start(); }
	
	@Override
	public void run()
	{
		tl.onStart(Calendar.getInstance().getTime());
		
		try 
		{ Thread.sleep(5000); }
		catch (InterruptedException e) 
		{ e.printStackTrace(); }
		
		tl.onFinish(Calendar.getInstance().getTime());
	}
	
	public static void main(String[] args)
	{
		new Task(new TaskListener()
		{
			@Override
			public void onStart(Date startTime)
			{
				System.out.println(getClass().getName() + " -> Start time: " 
						+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(startTime));
			}

			@Override
			public void onFinish(Date endTime)
			{
				System.out.println(getClass().getName() + " -> End time: " 
						+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(endTime));
			}
		})
		.start();
	}
}
