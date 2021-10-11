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
    }
}
