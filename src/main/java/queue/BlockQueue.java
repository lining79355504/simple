package queue;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mort on 04/05/2017.
 */
public class BlockQueue {

    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        // 启动线程
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);

        Thread.sleep(5* 2000);
        writeObjToDick(queue);

        service.execute(consumer);

        readObjFromFile("./obj.txt");

        // 执行10s
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
    }


    public static void writeObjToDick(Object obj) {

        //1、找到目标文件
        File file = new File("./obj.txt");
        //建立数据的输出流对象
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            //建立对象的输出流对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //把对象写出去
            objectOutputStream.writeObject(obj);//序列化house的内容 是给JVM看的 一般我们是看不懂的
            //关闭资源
            objectOutputStream.close();

        } catch (Exception e) {
        e.printStackTrace();
    }

        }




    public static void readObjFromFile(String fileName){

        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            BlockingQueue ret = (BlockingQueue) objectInputStream.readObject();
            System.out.println("read from " + JSON.toJSONString(ret));
        }catch (Exception e){
            e.printStackTrace();
        }


    }



}


