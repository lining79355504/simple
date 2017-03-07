package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mortli on 3/1/17.
 */
public class WaitNotifyTestB implements Runnable {


    private int number;
    public byte res[];
    public int count = 5;

    public WaitNotifyTestB(int number, byte a[]) {
        this.number = number;
        res = a;
    }

    public void run() {

        synchronized (res) {
            try {
                // res.wait();   //  释放锁 控制权交给CPU
//                res.notify();   //  唤醒等待res 的线程， 把锁交给线程 ， （该同步锁执行完毕自动释放）
                while (count-- > 0) {

                    //res.notify();   //  唤醒等待res 的线程， 把锁交给线程 ， （该同步锁执行完毕自动释放）
                    System.out.println(number + "---");

                    // res.notify();    //唤醒等待res 的线程， 把锁交给线程 ， （该同步锁执行完毕自动释放）
                    //res.wait();    //释放锁 控制权交给CPU）
                    System.out.println("线程名称" + Thread.currentThread().getName() + "获得锁，wait() 后的代码继续运行" + number);
                }
            //} catch (InterruptedException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
    }

}


class NumPrinter {

    public static void main(String[] args) {

        final byte a[] = {0};
        new Thread(new WaitNotifyTestB(1, a), "a1").start();
        new Thread(new WaitNotifyTestB(2, a), "b1").start();

        ExecutorService threadPool =  Executors.newCachedThreadPool();


        int i = 2;
        while (i-- > 0) {
            System.out.println("i am i " + i);


            threadPool.execute(new Runnable() {
                public void run() {

                    System.out.println(Thread.currentThread().getName()+" 900 "+fibonacci(100));
                }


                // 递归实现方式
                public  int fibonacci(int n){
                    if(n <= 2){
                        return 1;
                    }else{
                        return fibonacci(n-1) + fibonacci(n-2);
                    }
                }
            });





        }
        threadPool.shutdown();
        return;

    }

}
