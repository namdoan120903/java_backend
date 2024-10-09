import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class WorkThread implements Runnable{

  private String task;

  public WorkThread(String task) {
    this.task = task;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Start with "+ task);
    try{
      Thread.sleep(180);
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " Finish with " + task);
  }
}
//fixed thread pool
public class ThreadPool {
  public static final int NUM_OF_THREAD = 5;

  public static void fixedThreadPool(){
    ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREAD);
    for(int i=1; i<=10; i++){
      Runnable runnable = new WorkThread(""+i);
      executorService.execute(runnable);
    }
    executorService.shutdown();
  }

  public static void singleThreadPool(){
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    for(int i=1; i<=10; i++){
      Runnable runnable = new WorkThread(""+i);
      executorService.execute(runnable);
    }
    executorService.shutdown();
  }


  public static void main(String[] args) {
    System.out.println("Single Thread Pool");
    //singleThreadPool();
    System.out.println("Fixed Thread Pool");
    fixedThreadPool();

  }
}
