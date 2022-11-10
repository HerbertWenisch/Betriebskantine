

public class Aufräumer extends Thread {
    private Theke theke;
    private Tablett tablett;
    private long napTime = 300; // 300 ms
    
    public Aufräumer(Theke theke){
        this.theke = theke;
    }
    
    @Override
    public void run(){
        while (Test.count > 0){
            tablett = theke.wegnehmen();
            
            if(tablett != null)
              System.out.println("Aufräumer: Tablett abgeräumt");
            else  
              System.out.println("Aufräumer: Kein Tablett da!");
              
            Test.count--;
            nap();
        }
    }
    
    private void nap(){
        try {
            Thread.sleep(napTime);
        }
        catch(InterruptedException e) {}
    }
}
