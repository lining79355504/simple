package leetCode;

import org.junit.Test;

/**
 * Author:  lining17
 * Date :  2020-06-08
 */
public class DPTest {



    //不相邻数组最大值 动态规划
    /*
    * tmp[i] 第 i 个最大值
    * tmp[i] = max(tmp[i] + arr[i], arr[i]+tmp[i-1])
    *
    * */
    public int dpTest1(int[] arr) {
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        tmp[1] = Math.max(arr[0], arr[1]);
        tmp[2] = Math.max(arr[1], arr[0] + arr[2]);
        for (int i = 3; i < arr.length; i++) {
            tmp[i] = arr[i] + Math.max(tmp[i - 2], tmp[i - 3]);
        }
        return Math.max(tmp[tmp.length - 1], tmp[tmp.length - 2]);
    }

    //最大回文查找


    //股票交易



    @Test
    public void run() {
        int[] arr = {2, 5, 4, 5, 6, 9};
        System.out.println(dpTest1(arr));
    }






}
