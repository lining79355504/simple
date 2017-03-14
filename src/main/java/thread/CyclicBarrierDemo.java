package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mortli on 3/11/17.
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {
        int N = 4;

        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            public void run() {
                System.out.println("all thread break barrier ");  // do sth
            }
        });

        for (int i = 0; i < 6; i++) {     //  此处 线程数和 CyclicBarrier 数量不同的区别
            new Write(barrier).start();
        }

    }


    static class Write extends Thread {

        private CyclicBarrier cyclicBarrier;

        public Write(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }


        public void run() {
            try {

                System.out.println("thread " + Thread.currentThread().getName() + " read start......");
                sleep(2000);
                System.out.println("thread " + Thread.currentThread().getName() + " read end .......");

                cyclicBarrier.await();   // 从0开始增加的  countdownlatch 是减的   线程数多于cyclicBarrier 初始数会有线程在这个挂起 释放锁
                System.out.println("thread " + Thread.currentThread().getName() + " write ..... ");

            } catch (InterruptedException ie) {

                ie.printStackTrace();

            } catch (BrokenBarrierException be) {      //指定时间后 为执行完工作 抛出的异常

                be.printStackTrace();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }


    }
}
