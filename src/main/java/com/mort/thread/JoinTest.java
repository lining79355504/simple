package com.mort.thread;

import static java.lang.Thread.sleep;

/**
 * Created by mortli on 3/14/17.
 */
public class JoinTest {

    static class ThreadTest extends Thread {

        @Override
        public void run() {
            try {
                System.out.println(" thread " + Thread.currentThread().getName() + "start ");
//                Integer i = new Integer(0);
//                synchronized (i) {
                    //sleep(2000);
                    for (int i = 0; i < 50; i++) {   //  thread 内部的 变量都是线程安全的
                        if(i==30){
                            this.yield();  // 到yield 的时候 一定是进入就绪  所有线程一起竞争运营 可能是自己  也可能是别的线程
                            System.out.println(" thread " + Thread.currentThread().getName() + "   " + i + " run");
                            System.out.println();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println(" thread " + Thread.currentThread().getName() + "   " + i + " run");
                    }
//                }
                System.out.println(" thread " + Thread.currentThread().getName() + "end ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 5; i++) {
                Thread thisThread = new ThreadTest();
                thisThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
