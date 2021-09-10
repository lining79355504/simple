package com.mort.reentrantLock;

import java.lang.annotation.Documented;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mortli on 4/11/17.
 */
public class PrintQueue {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void printLog(Object Document) {

        reentrantLock.lock();
        Long duration = (long) (Math.random() * 10000);
        /* sout */
        System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a ReadJob during " + (duration / 1000) + " seconds");
        try {

            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            reentrantLock.unlock();
        }


    }

    public static void main(String[] args) {

        PrintQueue printQueue= new PrintQueue();
        Thread threadArr[] = new Thread[10];
        for (int i = 0; i < 10; i++) {

            threadArr[i] = new Thread(new Job(printQueue) , "Thread"+i);
            
        }
        for (int i = 0; i < threadArr.length; i++) {
            threadArr[i].start();
        }
    }


}
