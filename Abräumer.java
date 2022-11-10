public class Abräumer extends Thread {
    private int n;
    private Theke theke;
    private final long napTime = 600; // 600 ms
    
    Abräumer(int n, Theke theke){
        this.n = n;
        this.theke = theke;
    }
    
    @Override
    public void run(){ 
     boolean abgelegt;
     while (Test.count > 0){   
       abgelegt = theke.ablegen(new Tablett());   
       if(abgelegt) 
        System.out.println("Abräumer Nr " + n + " : Tablett abgelegt");
       else 
        System.out.println("Abräumer Nr " + n + " : Theke voll"); 
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
