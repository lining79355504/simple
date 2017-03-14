package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * Created by mortli on 3/11/17.
 */
public class FutureDemo {

    static class futureTest implements Callable<String> {

        public String call() throws Exception {
            //return Thread.currentThread().getName();
            return "test";
        }
    }

    public static void main(String[] args) {

        List<Future<String>> resultPool = new ArrayList<Future<String>>();

        List<String> result = new ArrayList<String>();
        ExecutorService cacheThreadDemoPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            try {
                // executorServers .submit 和execute   submit 会返回一个含有返回结果的future 对象  execute void
                cacheThreadDemoPool.execute(new Runnable() {
                    public void run() {

                    }
                });   //  execute  只能接受 Runnable 且无返回值   callAble 中的call 相当于 runnable 的run
                resultPool.add(cacheThreadDemoPool.submit(new futureTest()));

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        for (Future<String> item : resultPool) {
            try {
                System.out.println(item.toString());
                System.out.println(item.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println(resultPool);


    }
}
