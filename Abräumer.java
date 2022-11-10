import java.util.concurrent.locks.*;

public class Abräumer extends Thread {
    private int n;
    private Theke theke;
    private final long max_napTime = 600; // 400 ms
    private final Lock lock;
    
    Abräumer(int n, Theke theke, Lock lock){
        this.n = n;
        this.theke = theke;
        this.lock = lock;
    }
    
    @Override
    public void run(){ 
     while (Test.count > 0){  
       String abräumer = "Abräumer " + n + " ";  
       String full = "Theke ist voll";
       String abgelegt = "abgelegt";
       lock.lock();
         System.out.print(abräumer + ((theke.ablegen(new Tablett()))? abgelegt: full));  
         System.out.println("  count: " + theke.count());
       lock.unlock();
       Test.count--; 
       nap();
    }
  }
  
  private void nap(){
        long napTime = (long) Math.random()* max_napTime;
        try {
            Thread.sleep(napTime);
        }
        catch(InterruptedException e) {}
    }
}
