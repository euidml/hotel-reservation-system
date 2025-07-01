package lab10;

import java.util.Date;
/** Define ProducerRunnable class and its method(s)
 * 
 * @author edwardlee
 *
 */
public class ProducerRunnable implements Runnable {
	// data member here
	private Queue queue;
	private Date date;
	private int repeats;
	private static final int DELAY = 1;
	/** Constructs ProducerRunnable class object
	 * 
	 * @param queue a Queue objects behaviors like a Queue ADT
	 * @param repeats a positive integer number refers number of times to test
	 * 
	 *  Possibly throws NullPointerException if queue is null
	 *  				IllegalArgumentException if repeats <= 0
	 */
	public ProducerRunnable(Queue queue, int repeats) {
		if(queue == null)
			throw new NullPointerException("queue should not be null");
		if(repeats <= 0)
			throw new IllegalArgumentException("repeats should not be negative");
		this.queue = queue;
		this.date = new Date();
		this.repeats = repeats;
	}
	/** override method from Runnable interface; tests queue for repeat tiems*/
	@Override
	public void run() {
		try {
			for(int i = 0; i < repeats; i++) {
				String temp = this.date.toString();
				queue.add(temp);
				System.out.println("added to the queue: " + temp);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
