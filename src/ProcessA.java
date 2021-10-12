import java.util.concurrent.Semaphore;

public class ProcessA {
    private AllSemaphores allSemaphs;
    Semaphore sem1;
    Semaphore sem2;
    public ProcessA(AllSemaphores as) {
        allSemaphs = as;
        sem1 = allSemaphs.r;
        sem2 = allSemaphs.s;
        procA(sem1, sem2);
    }

    void procA(Semaphore sem1, Semaphore sem2) {
        allSemaphs.p(sem1);
        allSemaphs.p(sem2);
        try {
            wait();
        }
        catch (InterruptedException e){}
        allSemaphs.v(sem2);
        allSemaphs.v(sem1);

        // Deadlock has been achieved
        // 1. Mutual exclusion: Each Semaphore only has 1 permit, so only one process can have it at a time
        // 2. Hold and wait: Each process can request as many Semaphores as they like, providing there is an available permit
        // 3. No preemption: Due to the acquire() method another process must wait until the permit for that particular permit is released
        // 4. Circular wait: There are two processes trying to get both Semaphores
    }
}
