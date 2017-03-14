package thread;

/**
 * Created by mortli on 3/14/17.
 */
public class YieldTest {

    static class Athread extends Thread {


        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + ", A thread start ......");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " , A thread end ........");

            } catch (Exception e) {
                e.printStackTrace();

            }


        }

    }


    static class Bthread extends Thread {

        private Athread at;

        Bthread(Athread at) {
            this.at = at;
        }

        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + ", B thread start ......");
                Thread.sleep(2000);
                at.join();  //当前线程 等待所有子线程结束  ;
                //Thread.currentThread().join();   // 自己线程等待  会进入死锁 无法释放
                System.out.println(Thread.currentThread().getName() + " , B thread end ........");

            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }

    public static void main(String[] args) {

        try {
            Athread at = new Athread();
            Bthread bt = new Bthread(at);
            at.start();
            bt.start();
            //bt.join();   //当前线程等待所有子线程执行结束
            System.out.println(" all end ");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
