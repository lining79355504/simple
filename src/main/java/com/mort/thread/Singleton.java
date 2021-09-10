package com.mort.thread;

/**
 * Created by mort on 16/06/2017.
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        Singleton ins = instance; //增加临时变量
        if (ins == null) {
            synchronized (Singleton.class) {
                ins = instance;
                if (ins == null) {
                    ins = instance = new Singleton();
                }
            }
        }
        return ins;
    }

    public static Singleton normalInstance(){

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}