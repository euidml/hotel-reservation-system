package lab10;

/** Define HotelTester class and its method(s)
 * 
 * @author edwardlee
 *
 */
public class HotelTester {
	/** main method */
	public static void main(String[] args) throws InterruptedException {
		// create hotel here
		Hotel hotel = new Hotel();
		// create periodic customers here
		PeriodicCustomer smith = new PeriodicCustomer("smith", hotel);
		PeriodicCustomer john = new PeriodicCustomer("john", hotel);
		PeriodicCustomer peter = new PeriodicCustomer("peter", hotel);
		// assign threads for each customer
		Thread SmithThread = new Thread(smith);
		Thread JohnThread = new Thread(john);
		Thread PeterThread = new Thread(peter);
		// start each thread
		SmithThread.start();
		JohnThread.start();
		PeterThread.start();
		// assuming it passed 5 tasks for each customer within 1000 milliseconds
		Thread.sleep(1000);
		if(SmithThread.isAlive()){
			SmithThread.interrupt();
			JohnThread.interrupt();
			PeterThread.interrupt();
			
		}
		// printing the result
		System.out.print("\n\n" + hotel.reservationInformation());

	}
}
