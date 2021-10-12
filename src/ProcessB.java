import java.util.concurrent.Semaphore;

public class ProcessB {
    private AllSemaphores allSemaphs;
    Semaphore sem1;
    Semaphore sem2;
    public ProcessB(AllSemaphores as) {
        allSemaphs = as;
        sem1 = allSemaphs.r;
        sem2 = allSemaphs.s;
        procB(sem1, sem2);
    }

    void procB(Semaphore sem1, Semaphore sem2){
        allSemaphs.p(sem2);
        allSemaphs.p(sem1);
        try {
            wait();
        }
        catch (InterruptedException e){}
        allSemaphs.v(sem1);
        allSemaphs.v(sem2);
    }
}
