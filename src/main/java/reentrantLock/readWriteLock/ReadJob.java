package reentrantLock.readWriteLock;

import reentrantLock.PrintQueue;

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

        System.out.println(" read a " +Thread.currentThread().getName()+"  "+  prieceInfo.getPrieceA());

        System.out.println(" read b " +Thread.currentThread().getName()+"   " + prieceInfo.getPrieceB());


    }
}
