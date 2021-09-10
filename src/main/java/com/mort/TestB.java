package com.mort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mort on 04/05/2017.
 */
public class TestB {

    private String b ;

//    com.mort.TestB(String a){
//        this.b=a;
//    }

    public void changeB(){

        this.b = "change 了" ;
        System.out.println("change 了");
    }


    @Test
    public void test(){

        List parma = new ArrayList();
        System.out.println(parma);
//        preList(parma);
//        preListDirect(parma);
        System.out.println(parma);





    }

    //  java 基本类型都是值传递 会重新copy 一份 作为参数传递 修改的形参不会影响实参 对象都是引用传递
    public void preList(List parm){

        List a = new ArrayList();
        a.add(1);
//        int a = 8 ;
        // = 赋值操作 进本类型直接修改内存值  对象则是修改指向内存地址的首指针
        parm = a;    //用等于号就会生成一个栈区对象  = parm对象的地址会变成a的地址  由于在栈区会新生成一个对象

    }


    public void preListDirect(List parm){

        parm.add(1); // 修改的是实参的值 实际内存地址的值

    }

}
