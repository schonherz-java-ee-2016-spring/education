package hu.schonherz.java.training.thread;


public class SynchronizationTest extends Thread {
  
  private int number;
  private static SynchronizedObject synchronizedObject = new SynchronizedObject();

  public SynchronizationTest(int number) {
    super();
    this.number = number;
  }

  @Override
  public void run() {
    int i = 0;
    synchronized (synchronizedObject) { // Only one thread can run this block
                                        // In this case the Thread2 won't run till Thread1 finish the "while"
      while(i < 5) {
        i++;
        //synchronized(synchronizedObject) { // Only one thread can run this block
                                             // Thread2 can run it while Thread1 execute other part of while
          System.out.println(number + " - " + synchronizedObject.getNum());
        //}
      }
    }
  }
  
  @Override
  public synchronized void start() {
    System.out.println(number + ". started");
    super.start(); 
  }

}
