package airthmethic;

import org.junit.Test;

/**
 * Created by mortli on 3/7/17.
 */
public class Permutation {

    @Test
    public void test() {

        //char [] a = {'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l' };
        char[] a = {'a', 'b', 'c', 'd', 'e'};


        //permutation(a, 0, a.length);

        System.out.println(fobnaic(10));
        System.out.println(fibonacci(10));

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

}

