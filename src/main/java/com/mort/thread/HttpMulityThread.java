package com.mort.thread;

import com.mort.http.HttpRequest;
import com.mort.http.HttpRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mortli on 3/1/17.
 */
public class HttpMulityThread {

    private static int count = 1000;


    public static void main(String[] args) {

        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

       final ThreadLocal<HttpRequest> httpRequestThreadLocal = new ThreadLocal<HttpRequest>(){
            @Override
            public HttpRequest initialValue(){
                return new HttpRequest();
            }

        };

        while (count-- > 0) {
            cacheThreadPool.execute(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        HttpRequest httpRequest = httpRequestThreadLocal.get();
                        //String ret = HttpRequest.sendGet("http://localhost/", "");
                        String ret = httpRequest.sendGet("http://localhost:8080/hello", "");

                        //System.out.println(" i " + Thread.currentThread().getName() + count + ret);
                        System.out.println(" i " + Thread.currentThread().getName() + count );
                    }


                }
            });
        }

        cacheThreadPool.shutdown();

    }
}
