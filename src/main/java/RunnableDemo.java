
class Runnable1 implements Runnable{
  private Thread thread;
  private String name;

  public Runnable1(String name) {
    this.name = name;
    System.out.println("Create thread " + name);
  }

  public void start(){
    System.out.println("thread is start");
    if(thread == null){
      thread = new Thread(this, name);// truyen runnable la chinh class nay
    }
    thread.start();
  }

  @Override
  public void run() {
    System.out.println("thread is running");

      try {
        for(int i=0; i<5; i++) {
          System.out.println("Thread " + name + " running " + i);
          Thread.sleep(10);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    System.out.println("Thread is end");
  }
}

public class RunnableDemo{

  public static void main(String[] args) {
    Runnable1 runnable1 = new Runnable1("A");
    Runnable1 runnable2 = new Runnable1("B");
    runnable1.start();
    runnable2.start();
  }
}
