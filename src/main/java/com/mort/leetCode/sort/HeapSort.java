package com.mort.leetCode.sort;

import java.util.Arrays;

/**
 * @author mort
 * @Description
 * @date 2021/10/8
 **/
public class HeapSort {

    public int[] sort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        int length = sourceArr.length;

        //构建大顶堆

        //将堆最大值放到 最后一个

        //
        for (int i = 0; i < length -1 ; i++) {
//            swap(arr, length, );
            length = length -1;
        }
        return new int[0];
    }


    public void buildMaxHeap(int[] arr, int length) {
        

    }

    public void swap(int[] arr, int i, int j) {

    }
}
