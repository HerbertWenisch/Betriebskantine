import java.util.concurrent.locks.*;

public class Test {
    public static int count = 80;
    private final int N = 4;
    private Theke theke;
    private Lock lock = new ReentrantLock();
    private Abräumer[] abräumers;
    private Aufräumer aufräumer;

    Test(){
       theke = new Theke(); 
       abräumers = new Abräumer[N];
       for(int i = 0; i < N; i++)
          abräumers[i] = new Abräumer(i, theke, lock);
       aufräumer = new Aufräumer(theke, lock);   
    }
    
    public void testing(){
        for(int i = 0; i < N; i++)
            abräumers[i].start();
        aufräumer.start();    
    }
}
