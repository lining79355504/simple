package thread.threadFactory;

/**
 * Created by mort on 28/07/2017.
 */
public class WorkRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
