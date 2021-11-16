/**
 * Abi 2012 III 2
 *
 * @author (HerbertWenisch)
 * @version (06.11.21)
 */

public class Theke {
    private final int N = 10;
    private Tablett[] tabletts = new Tablett[N];
    private int count = N;  // erster freier Platz im Array

    private boolean isFull(){
        return count == N;
    }
    
    private boolean isEmpty(){
        return count == 0;
    }

    public synchronized boolean ablegen(Tablett t){
        if(isFull()) return false;
        // not full:
        tabletts[count]= t;
        count++;
        return true;
    }
    

    public synchronized Tablett wegnehmen(){
        if(isEmpty()) return null;
        // not empty:
        count--;
        return tabletts[count];
    }
}
