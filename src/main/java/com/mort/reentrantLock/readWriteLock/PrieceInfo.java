package com.mort.reentrantLock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by mortli on 4/11/17.
 */
public class PrieceInfo {

    public ReentrantReadWriteLock readWriteLock; // =  new ReentrantReadWriteLock();

    public double prieceA = 0.01;

    public double prieceB = 0.03;

    public PrieceInfo(){
        this.readWriteLock = new ReentrantReadWriteLock();
    }


    /**
     *    getA 或者getB 的读锁 会被 写锁抢占到 ， 写锁释放后 会还给上一个被抢占的持有锁者,  返回的是上一个锁持有者 之前的线程缓存值
     *    不是volatile 硬件级别保证可见形  会主动刷新CPU高速缓存 另所有线程缓存失效 主动从内存获取最新变量
     *
     *
     *
     * */
    public double getPrieceA() {

        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+" read A start" );
        return this.prieceA;
//        System.out.println(Thread.currentThread().getName()+" read A end" );
//        readWriteLock.readLock().unlock();

    }


    public double getPrieceB() {

//        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+" read B start" );
        return this.prieceB;
//        System.out.println(Thread.currentThread().getName()+" read B end" );
//        readWriteLock.readLock().unlock();
//
//        return value;

    }


    public boolean setPrieceA(double valA, double valB) {

        readWriteLock.writeLock().lock();
        this.prieceA = valA;
        this.prieceB = valB;
        readWriteLock.writeLock().unlock();
        return true;

    }




}
