import java.util.concurrent.Semaphore;

public class ProcessB extends Thread {
    Semaphore semR;
    Semaphore semS;

    public ProcessB(Semaphore sem1, Semaphore sem2) {
        this.semR = sem1;
        this.semS = sem2;
    }

    public void run(){
        try {
            semS.acquire();
            semR.acquire();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
            semR.release();
            semS.release();
        }
        catch (Exception e){}
    }
}
