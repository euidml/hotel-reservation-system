package lab10;

import java.util.Random;
/** Define PeriodicCustomer class and its method
 * 
 * @author edwardlee
 *
 */
public class PeriodicCustomer implements Runnable{
	// data memebers here
	private Hotel hotel;
	private String name;
	private static final int DELAY = 100;
	private Random ran = new Random();
	
	/** Constructs PeriodicCustomer class object
	 * 
	 * @param name a String object refers custotmer's name
	 * @param hotel a Hotel class object
	 * 
	 * Possibly throws  NullPointerException if hotel is null
	 * 					NullPointerException if name is null
	 *  				IllegalArgumentException if name == 0
	 */
	public PeriodicCustomer(String name, Hotel hotel) {
		if(hotel == null)
			throw new NullPointerException("hotel should not be null");
		if(name == null)
			throw new NullPointerException("name should not be null");
		if(name.length() == 0)
			throw new IllegalArgumentException("name should not have length 0");
		this.name = name;
		this.hotel = hotel;
	}
	/** A method tests a customer trying to make a reservation, assuming start and last are valid.
	 * 
	 * @param start an integer refers start date of reservation
	 * @param last an integer refers end date of reservation
	 */
	public void reserve(int start, int last) {
		if(hotel.requestReservation(this.name, start, last)) 
			System.out.println("Reservation made: " + this.name + " from "+start+" through "+last);
		else
			System.out.println("Reservation unsuccessful: " + this.name + " from "+start+" through "+last);
	}
	/**A method tests a customer trying to cancel his/her reservation.
	 * 
	 */
	public void cancel() {
		if(hotel.cancelReservation(this.name))
			System.out.println("Reservations successfully canceled for " + this.name);
		else
			System.out.println("Reservations not canceled for " + this.name+", no current reservation.");
	}
	/** override method from Runnable interface; tests either reserve() or cancel() randomly until its thread is interrupted*/
	@Override
	public void run() {
		try {
			while(true) {
				if((int)ran.nextInt(2) == 0)
					this.cancel();
				else {
					int first = 1 + ran.nextInt(31);
					int last = first + ran.nextInt(32 - first);
					this.reserve(first, last);
				}
				Thread.sleep(DELAY);
			}
		}catch(InterruptedException e) {
			System.out.println("Periodic Test Customer "+this.name + " Shutting Down");
		}
	}
	
}
