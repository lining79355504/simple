package thread;

import http.HttpRequest;

import java.util.concurrent.Callable;

/**
 * Created by mort on 07/06/2017.
 */
public class HttpBenchMarkFutureTask implements Callable<String> {

    private final   ThreadLocal<HttpRequest> httpRequestThreadLocal ;

    private final int concurrent ;
    public HttpBenchMarkFutureTask(ThreadLocal<HttpRequest> httpRequestThreadLocal , int concurrent) {
        this.httpRequestThreadLocal = httpRequestThreadLocal;
        this.concurrent = concurrent ;
    }

    @Override
    public String call() throws Exception {
        int concurrent_copy = concurrent ;
        while (concurrent_copy-->0) {

            HttpRequest httpRequest = httpRequestThreadLocal.get();
            //String ret = HttpRequest.sendGet("http://localhost/", "");
            String ret = httpRequest.sendGet("http://localhost:8080/hello", "");
            System.out.println("concurrent is :" + concurrent);
            System.out.println("concurrent_copy is :" + concurrent_copy);
            //System.out.println(" i " + Thread.currentThread().getName() + count + ret);
            //System.out.println(" i " + Thread.currentThread().getName() + count );

        }

        return null ;

    }

}
