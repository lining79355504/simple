package com.mort.thread.threadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mort on 28/07/2017.
 */
public class ThreadFactoryThreadPoolTest {



    public static void main(String[] args) {


        ExecutorService executorService =  Executors.newCachedThreadPool(new ThreadFactoryTest());
        for (int i = 0; i < 20; i++) {
            executorService.submit(new WorkRunnable());
        }

        //指示当所有线程执行完毕后关闭线程池和工作线程，如果不调用此方法，jvm不会自动关闭
        executorService.shutdown();

        try {
            //等待线程执行完毕，不能超过2*60秒，配合shutDown
            executorService.awaitTermination(2*60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


}
