package reentrantLock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by mortli on 4/11/17.
 */
public class PrieceInfo {

    private ReentrantReadWriteLock readWriteLock; // =  new ReentrantReadWriteLock();

    public double prieceA = 0.01;

    public double prieceB = 0.03;

    public PrieceInfo(){
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    public double getPrieceA() {

        readWriteLock.readLock().lock();
        double value = prieceA;
        readWriteLock.readLock().unlock();

        return value;

    }


    public double getPrieceB() {

        readWriteLock.readLock().lock();
        double value = prieceB;
        readWriteLock.readLock().unlock();

        return value;

    }


    public boolean setPrieceA(double valA, double valB) {

        readWriteLock.writeLock().lock();
        this.prieceA = valA;
        this.prieceB = valB;
        readWriteLock.writeLock().unlock();
        return true;

    }




}
