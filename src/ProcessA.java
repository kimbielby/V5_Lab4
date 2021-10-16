import java.util.concurrent.Semaphore;

public class ProcessA extends Thread {
    Semaphore semR;
    Semaphore semS;

    public ProcessA(Semaphore sem1,Semaphore sem2) {
        this.semR = sem1;
        this.semS = sem2;
    }

    public void run () {
        try {
            semR.acquire();
            semS.acquire();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {}
            semS.release();
            semR.release();
        }
        catch (Exception e) {}


        // Deadlock has been achieved
        // 1. Mutual exclusion: Each Semaphore only has 1 permit, so only one process can have it at a time
        // 2. Hold and wait: Each process can request as many Semaphores as they like, providing there is an available permit
        // 3. No preemption: Due to the acquire() method another process must wait until the permit for that particular permit is released
        // 4. Circular wait: There are two processes trying to get both Semaphores
    }
}

