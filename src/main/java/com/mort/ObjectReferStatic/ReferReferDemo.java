package com.mort.ObjectReferStatic;

/**
 * Created by mort on 16/06/2017.
 */
public class ReferReferDemo {

    public static void main(String[] args) {

        ReferStaticCaseGCDemo referStaticCaseGCDemo = new ReferStaticCaseGCDemo();
        referStaticCaseGCDemo.referStaticCaseGCDemoFunction();

        referStaticCaseGCDemo = null ;
        while (true);

    }
}
