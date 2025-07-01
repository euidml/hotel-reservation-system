package lab10;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**Define Queue(FIFO) class and its method(s)
 * 
 * @author edwardlee
 *
 */
public class Queue {
	// data members here
	private ArrayList<String> queue;
	private int maxQueueSize;
	private Lock queueLock;
	private Condition longWait;
	private Condition emptyQueue;
	
	
	/** Constructs Queue class object
	 * 
	 * @param maxQueueSize a positive integer represents the maximum size of the queue
	 * 
	 * Possibly throws IllegalArgumentException if maxQueueSize <= 0
	 */
	public Queue(int maxQueueSize) {
		if(maxQueueSize <= 0)
			throw new IllegalArgumentException("maxQueueSize should not be negative");
		this.queue = new ArrayList<String>();
		this.maxQueueSize = maxQueueSize;
		queueLock = new ReentrantLock();
		longWait = queueLock.newCondition();
		emptyQueue = queueLock.newCondition();
		
	}
	/** A method to add String object at the rear of the queue ADT
	 * 
	 * @param temp a String object
	 */
	public void add(String temp) {
		queueLock.lock();
		try {
			while(this.queue.size() >= this.maxQueueSize) 
				longWait.await();
			this.queue.add(temp);
			emptyQueue.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
	}
	/** A method to pop String from the head of the queue
	 * 
	 * @return a String object  
	 */
	public String remove() {
		queueLock.lock();
		String temp = "";
		try {
			while(this.queue.isEmpty())
				emptyQueue.await();
			temp = this.queue.remove(0);
			longWait.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
		return temp;
	}
}
