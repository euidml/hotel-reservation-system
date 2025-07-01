package lab10;

/** Define ProducerConsumerRunner class and its method(s)
 * 
 * @author edwardlee
 *
 */
public class ProducerConsumerRunner
{
	/** Main method to test Queue class periodically*/
   public static void main(String args[])
   {
      Queue q = new Queue(QUEUE_MAX_SIZE);
      ProducerRunnable producer = new ProducerRunnable(q, ITERATIONS);
      ConsumerRunnable consumer = new ConsumerRunnable(q, ITERATIONS);
      Thread t1 = new Thread(producer);
      Thread t2 = new Thread(consumer);
      t1.start();
      t2.start();
   }
   // data members here
   private final static int QUEUE_MAX_SIZE = 10;
   private final static int ITERATIONS = 100;
}

