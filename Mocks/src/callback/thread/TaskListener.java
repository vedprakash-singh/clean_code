package callback.thread;

import java.util.Date;

public interface TaskListener
{
	/**
	 * Called on start of the task
	 * @param startTime
	 */
	public void onStart(Date startTime);
	
	/**
	 * Called at the end of the task.
	 * @param endTime
	 */
	public void onFinish(Date endTime);
}
