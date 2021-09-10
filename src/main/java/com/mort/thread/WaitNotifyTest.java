package com.mort.thread;

/**
 * Created by mortli on 3/1/17.
 */
public class WaitNotifyTest {

    public class NumPrinter implements Runnable{
        private int number;
        public byte res[];
        public int count = 5;

        public NumPrinter(int number, byte a[]) {
            this.number = number;
            this.res = a;
        }

        public void run() {

            while (count-- > 0) {

                System.out.println(number + "---");

                try {
                    System.out.println("线程名称" + Thread.currentThread().getName() + "获得锁，wait() 后的代码继续运行" + number);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args) {
        final byte a[] = {0};
      //  new Thread(new NumPrinter(1 , a) , "1").start();
      //  new Thread().start();
    }

}
