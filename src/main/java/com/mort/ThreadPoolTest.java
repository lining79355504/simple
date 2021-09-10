package com.mort;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:  lining17
 * Date :  2019-06-04
 */
public class ThreadPoolTest {


    public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5, new ThreadFactory() {

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,
                    "cat-schedule-pool-"+threadNumber.incrementAndGet());
            return t;
        }
    });

    public static void main(String[] args) {
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread is "+ Thread.currentThread().getName()+ " start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread is "+ Thread.currentThread().getName()+ " end");
            }
        },0,5, TimeUnit.MILLISECONDS);
    }
}
