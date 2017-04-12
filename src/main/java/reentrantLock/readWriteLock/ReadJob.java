package reentrantLock.readWriteLock;

import reentrantLock.PrintQueue;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by mortli on 4/11/17.
 */
public class ReadJob implements Runnable {

    private PrieceInfo prieceInfo;

    public ReadJob(PrieceInfo prieceInfo) {
        this.prieceInfo = prieceInfo;
    }

    @Override
    public void run() {

//        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//        readWriteLock.readLock().lock();
//  锁必须在一个对象里  一个内存空间 作为竞态资源共享 多线程之间一定要是共享的  否则无任何意义
// 必须在堆区  这样在方法栈里 是无法共享的 错的离谱

        System.out.println(" read a " +Thread.currentThread().getName()+"  "+  prieceInfo.getPrieceA());

        System.out.println(" read b " +Thread.currentThread().getName()+"   " + prieceInfo.getPrieceB());
//        readWriteLock.readLock().unlock();

    }
}
