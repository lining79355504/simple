package com.mort.airthmethic;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mortli on 3/7/17.
 */
public class Permutation {

    @Test
    public void test() {

        //char [] a = {'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l' };
        char[] a = {'a', 'b', 'c', 'd', 'e'};


//        permutation(a, 0, a.length);

        System.out.println(signedSum(5,0));

//        System.out.println(fobnaic(10));
//        System.out.println(fibonacci(10));

        System.exit(0);


    }

    /**
     * 全排列输出
     *
     * @param a [] 要输出的字符数组
     * @param m 输出字符数组的起始位置
     * @param n 输出字符数组的长度
     */
    public void permutation(char a[], int m, int n) {
        int i;
        char t;
        if (m < n - 1) {
            permutation(a, m + 1, n);
            for (i = m + 1; i < n; i++) {
                t = a[m];
                a[m] = a[i];
                a[i] = t;
                permutation(a, m + 1, n);
                t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
        } else {
            printResult(a);
        }
    }

    /**
     * 输出指定字符数组
     *
     * @param text 将要输出的字符数组
     */
    public void printResult(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }


    // 后一个数比前一个多2  不是斐波那契饿数列
    // 如果求和 遍历n个数求和  加递归  递归算参数为n 的数
    public int fobnaic(int n) {

        if (n == 0) return 0;
        if (n == 1)
            return 1;
        if (n >= 2) {
            return fobnaic(n - 1) + 2;
        }
        return 0;

    }
    //斐波那契数列  后一个是前两个数的和
    public int fibonacci(int n){

        if(n==0)
            return 0 ;
        if(n==1)
            return 1 ;
        if(n>=2)
            return fibonacci(n-1)+fibonacci(n-2);    // 注意不能是 fibonacci(n)+ fibonacci(n-1)   这样跳不出循环 会栈溢出
        return 0 ;
    }

    //后一个数是前面所有数据的和 ？？
    public int forwardAllSum(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n >= 2) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += signedSum(i,sum);
            }
            return sum;
        }
        return 0;
    }

    public int signedSum(int n, int sum) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n >= 2) {
            for (int i = 0; i < n; i++) {
                sum += signedSum(i, sum);
            }
            return sum;
        }
        return 0;
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        test_new_params(list);
        System.out.println(JSON.toJSONString(list));
    }

    // new 默认新建一个对象
    static void test_new_params(List<String> list) {
        List<String> lista = new ArrayList<>();
        lista.add("2");
        lista.add("4");
        list = lista;  //相当于new 此时的参数list地址指向会变成局部变量lista  String = 相当于装箱 指向其他对象
        list.add("5");
    }

    static void test_params(List<String> list) {  // 没有new 指向的还是传入的地址。
        list.add("2");
        list.add("4");
    }




}

