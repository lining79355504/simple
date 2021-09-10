package com.mort.thread;

import java.text.DateFormat;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mortli on 12/20/16.
 */
public class UtilConcurrent {


        public static void main(String[] args)
        {
            ExecutorService service = Executors.newCachedThreadPool();
            final Exchanger<String> exchanger = new Exchanger<String>();
            service.execute(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        String dateString = "2012-12-06 ";
                        DateFormat dateFormat = SafeDataFormate.getDateFormatByPattern(DatePatternEnum.DatePattern);
                        System.out.println(dateFormat.parse(dateString));

                        String data1 = "零食";
                        System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                        Thread.sleep((long) (Math.random() * 1000));
                        String data2 = exchanger.exchange(data1);       //两个线程都执行到次方法后会交换数据  是Exchange类只能同步2个线程
                        System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                    }
                    catch (Exception e)
                    {
                    }
                }
            });

            service.execute(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        String dateString = "2012-12-06 ";
                        DateFormat dateFormat = SafeDataFormate.getDateFormatByPattern(DatePatternEnum.DatePattern);
                        System.out.println(dateFormat.parse(dateString));

                        String data1 = "钱";
                        System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                        Thread.sleep((long) (Math.random() * 1000));
                        String data2 = exchanger.exchange(data1);          //两个线程都执行到次方法后会交换数据   是Exchange类只能同步2个线程
                        System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                    }
                    catch (Exception e)
                    {
                    }
                }
            });
        }

}
