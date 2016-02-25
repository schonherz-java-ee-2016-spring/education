package hu.schonherz.java.training.thread;


public class SynchronizedObject {
  
  private int num = 0;
  
  public int getNum() {
    num++;
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return num;
  }

}
