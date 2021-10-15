import java.util.concurrent.Semaphore;

public class CallEmUp {

    public static Semaphore r;
    public static Semaphore s;

    public CallEmUp()  {
        r = new Semaphore(1);
        s = new Semaphore(1);

        ProcessA processAThread = new ProcessA(r,s);
        ProcessB processBThread = new ProcessB(r,s);

        processAThread.start();
        processBThread.start();

    }

    static public void main(String[] args) throws InterruptedException {
        CallEmUp callEmUpInst = new CallEmUp();
    }
}
