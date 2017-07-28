package thread.threadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mort on 28/07/2017.
 */
public class ThreadFactoryThreadPoolTest {



    public static void main(String[] args) {


        ExecutorService executorService =  Executors.newCachedThreadPool(new ThreadFactoryTest());
        for (int i = 0; i < 20; i++) {
            executorService.submit(new WorkRunnable());
        }



    }


}
