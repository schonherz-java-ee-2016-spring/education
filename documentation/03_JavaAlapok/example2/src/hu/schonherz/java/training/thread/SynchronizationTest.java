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
    while(i < 5) {
      i++;  
      System.out.println(number + " - " + synchronizedObject.getNum());
    }
  }
  
  @Override
  public synchronized void start() {
    System.out.println(number + ". started");
    super.start(); 
  }

}
