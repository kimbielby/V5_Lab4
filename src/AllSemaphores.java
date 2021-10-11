import java.util.concurrent.Semaphore;

public class AllSemaphores  {
    Semaphore r;
    Semaphore s;

    public AllSemaphores(){
        r = new Semaphore(1);
        s = new Semaphore(1);
    }
    public synchronized void p(Semaphore sem){

        try {
            sem.acquire();
        }
        catch (InterruptedException e){ }

    }

    public synchronized void v(Semaphore sem){
        try {
            sem.release();
        }
        catch (IllegalArgumentException e){}
    }

}
