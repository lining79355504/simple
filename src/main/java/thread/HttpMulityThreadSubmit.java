package thread;

import http.HttpRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mortli on 3/1/17.
 */
public class HttpMulityThreadSubmit {

    /*
    *  打开Tomcat Nginx 最大连接配置
    *
    *     <Connector port="8080" protocol="HTTP/1.1"
                maxThreads="12000"
                minSpareThreads="500"
                maxSpareThreads="600"
                acceptCount="2000"
               connectionTimeout="10000"
               redirectPort="8443" />
    *
    *
    *
    * */
    private static int count = 2000;


    public static void main(String[] args) {

        List<Future<String>> taskRetList = new ArrayList<>();

        BlockingQueue taskRetQueue = new LinkedBlockingQueue();

        ConcurrentHashMap taskRetHaspMap = new ConcurrentHashMap<>();

        //ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2200);

       final ThreadLocal<HttpRequest> httpRequestThreadLocal = new ThreadLocal<HttpRequest>(){
            @Override
            public HttpRequest initialValue(){
                return new HttpRequest();
            }

        };

        HttpBenchMarkFutureTask httpBenchMarkFutureTask = new HttpBenchMarkFutureTask(httpRequestThreadLocal,20);

        while (count-->0){

            taskRetList.add(fixedThreadPool.submit(httpBenchMarkFutureTask));

        }

        //future.get 设置线执行超时时间
        fixedThreadPool.shutdown();  // 不在接受新的任务已经加入的任务会继续执行 shutdownNow()终止已经提交的任务

        while (!fixedThreadPool.isTerminated());  // shutdown 后 所有任务都执行完全的时候 返回TRUE 使用前必须shutdown 否则永远都返回FALSE


        for (int i=0 ; i< taskRetList.size(); i++){

            try {
                System.out.println(" i is :    " + i + "    ret is : "+ taskRetList.get(i).get(2000 ,TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }



    }
}
