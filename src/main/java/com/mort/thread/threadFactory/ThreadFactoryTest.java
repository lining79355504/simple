package com.mort.thread.threadFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mort on 28/07/2017.
 * 实现线程自增命名
 */
public class ThreadFactoryTest implements ThreadFactory{


    private final ThreadGroup threadGroup ;

    private AtomicInteger  mCount = new AtomicInteger(1);

    public ThreadFactoryTest() {
        SecurityManager s = System.getSecurityManager();
        threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }


    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(threadGroup , r , "thread"+mCount.incrementAndGet() , 0);
        thread.setDaemon(true);   // 设置deamon 线程
        return thread;
    }
}
