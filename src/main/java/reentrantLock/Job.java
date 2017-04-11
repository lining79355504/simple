package reentrantLock;

/**
 * Created by mortli on 4/11/17.
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;

    }


    @Override
    public void run() {


    }
}
