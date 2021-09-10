package com.mort.thread;

/**
 * Created by mort on 16/06/2017.
 */
public class VolatileDemo {


    public static void main(String[] args) {

        try {
            //有临时变量
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000 * 1000L; i++) {

                Singleton.getInstance();
            }

            Long end = System.currentTimeMillis();

            System.out.println(" thread : is " + Thread.currentThread().getName() + " use : " + (end - start));

            //没有临时变量
            Long startA = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000 * 1000L; i++) {

                Singleton.normalInstance();
            }

            Long endA = System.currentTimeMillis();

            System.out.println(" thread : is " + Thread.currentThread().getName()+ " use : "  + (endA - startA));

            new Thread(new Runnable() {
                @Override
                public void run() {

                    //有临时变量
                    Long start = System.currentTimeMillis();
                    for (int i = 0; i < 2000 * 100L; i++) {

                        Singleton.getInstance();
                    }

                    Long end = System.currentTimeMillis();

                    System.out.println(" thread : is " + Thread.currentThread().getName()+ " use : "  + (end - start));


                    //没有临时变量
                    Long startA = System.currentTimeMillis();
                    for (int i = 0; i < 2000 * 100L; i++) {

                        Singleton.normalInstance();
                    }

                    Long endA = System.currentTimeMillis();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" thread : is " + Thread.currentThread().getName()+ " use : "  + (endA - startA));

                }
            }).start();

            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {


                            //没有临时变量
                            Long startA = System.currentTimeMillis();
                            for (int i = 0; i < 2100000000L; i++) {

                                Singleton.normalInstance();
                            }

                            Long endA = System.currentTimeMillis();

                            System.out.println(" thread : is " + Thread.currentThread().getName()+ " use : "  + (endA - startA));


                            //有临时变量
                            Long start = System.currentTimeMillis();
                            for (int i = 0; i < 2100000000L; i++) {

                                Singleton.getInstance();
                            }

                            Long end = System.currentTimeMillis();

                            System.out.println(" thread : is " + Thread.currentThread().getName()+ " use : "  + (end - start));



                        }
                    }
            ).start();

        } catch (Exception e) {

            e.printStackTrace();

        }


    }



    public void testA(){

            throw  new RuntimeException();
    }


}
