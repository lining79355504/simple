package com.mort.reentrantLock.readWriteLock;

/**
 * Created by mortli on 4/11/17.
 */
public class WriteJob implements Runnable {


    private PrieceInfo prieceInfo;

    public WriteJob(PrieceInfo prieceInfo){
        this.prieceInfo = prieceInfo ;
    }


    @Override
    public void run() {

        System.out.println(" write start ");
        prieceInfo.setPrieceA(3.4 , 5.6);
        System.out.println(" write end ");

    }


    public static void main(String[] args) {

        PrieceInfo prieceInfo = new PrieceInfo();


        Thread readThreads[] = new Thread[10];
        Thread writeThread = new Thread();
        writeThread = new Thread(new WriteJob(prieceInfo) , "write thread");
        //writeThread.start();
        for (int i = 0; i < 10; i++) {
            readThreads[i] = new Thread(new ReadJob(prieceInfo), "read thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            readThreads[i].start();
            if(4== i){
                writeThread.start();
            }
        }


    }
}
