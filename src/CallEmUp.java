public class CallEmUp {

    public CallEmUp(){
        AllSemaphores allSemaphs = new AllSemaphores();
        ProcessA processA = new ProcessA(allSemaphs);
        ProcessB processB = new ProcessB(allSemaphs);

    }
    static public void main(String[] args){
        CallEmUp callEmUpInst = new CallEmUp();
    }
}
