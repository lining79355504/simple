package com.mort;

/**
 * Created by mort on 04/05/2017.
 */
public class TestA {

    private int b ;

    TestA(int a){
        this.b=a;

    }

    public void changeTest(){
        int c = 4;
        changec(c);
        System.out.println("c = [" + c + "]");
    }

    public void changeB(){

        this.b = 4 ;
        System.out.println("change this.b = 4");
    }

    public void changec(int c){
        c=5;
    }

    public static void main(String[] args){
        TestA testA = new TestA(1);
        testA.changeTest();
    }
}
