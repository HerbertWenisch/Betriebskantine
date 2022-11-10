

public class Test {
    public static int count = 80;
    private final int N = 4;
    private Theke theke;
    private Abräumer[] abräumers;
    private Aufräumer aufräumer;

    Test(){
       Theke theke = new Theke(); 
       abräumers = new Abräumer[N];
       for(int i = 0; i < N; i++)
          abräumers[i] = new Abräumer(i, theke);
       aufräumer = new Aufräumer(theke);   
    }
    
    public void testing(){
        for(int i = 0; i < N; i++)
            abräumers[i].start();
        aufräumer.start();    
    }
}
