package com.mort.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mortli on 3/11/17.
 */
public class CountdownLatchDemo {


    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(1);  // 注意1和2 的区别

        new Thread() {

            public void run() {
                try {
                    System.out.println("thread " + Thread.currentThread().getName() + "work start ......");
                    sleep(2000);
                    System.out.println("thread " + Thread.currentThread().getName() + "work end ......");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {

                try {
                    System.out.println("thread " + Thread.currentThread().getName() + "work start ......");
                    sleep(500);
                    System.out.println("thread " + Thread.currentThread().getName() + "work end ......");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();

//        while (true) {
//            System.out.println("latch count " + latch.getCount());
//            if (latch.getCount() == 2) break;
//        }


        try {
            /*
            * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
            * */
            latch.await();  ////调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行

            System.out.println("thread execute done ");

        } catch (Exception e) {

        }

    }

}
