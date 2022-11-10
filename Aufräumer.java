import java.util.concurrent.locks.*;

public class Aufräumer extends Thread {
    private Theke theke;
    private Tablett tablett;
    private long max_napTime = 200; // 200 ms
    private final Lock lock;
    
    public Aufräumer(Theke theke, Lock lock){
        this.theke = theke;
        this.lock = lock;
    }
    
    @Override
    public void run(){
        while (Test.count > 0){
            String empty = "Aufräumer: Kein Tablett da";
            String remove = "Aufräumer: Tablett aufgeräumt";
            lock.lock();
              System.out.print((theke.wegnehmen()== null)? empty: remove);
              System.out.println(" count: " + theke.count());
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
