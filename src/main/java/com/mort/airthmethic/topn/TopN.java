package com.mort.airthmethic.topn;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author mort
 * @Description
 * @date 2/5/24
 **/
public class TopN {


    /**
     * 构建大顶堆
     * 注意：
     * 这个方法并不是将整个树调整成大顶堆
     * 而是以i对应的非叶子结点的子树调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子结点在数组中的索引(下标)
     * @param length 进行调整的元素的个数，length是在逐渐减少的
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 取出当前非叶子结点的值保到临时变量中
        int temp = arr[i];

        // j=i*2+1表示的是i结点的左子结点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 比较左右子节点，找到较大的那个
            // 左子结点小于右子结点
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                // j指向右子结点
                j++;
            }

            // 较大的子节点与父节点进行比较，如果子节点大于父节点
            if (arr[j] > temp) {
                // 把较大的值赋值给父节点
                arr[i] = arr[j];
                // arr[j] = temp; 这里没必要换，让i指向与其换位的子结点，在最后赋值即可
                i = j; //
            } else {
                // 子树已经是大顶堆了
                break;
            }
        }
        arr[i] = temp;
    }



    public static void heapSort(int[] arr) {
        // arr.length/2-1开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 经历过刚刚的调整，现在数组已经是一个大顶堆，
        // 也就是满足arr[i] >= arr[2*i] && arr[i] >= arr[2*i+1]
        // 所以第一个元素就是最大值
        for (int j = arr.length - 1; j > 0; j--) {
            // 将最大值与最后一个元素调换，将最大值放到最后
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            // 调整0-j进行大顶堆重置
            adjustHeap(arr, 0, j);
        }
    }

    @Test
    public void heapTest(){
        int[] array = {4,2,5,3,6,1,7};
        heapSort(array);
        ArrayList<Integer> a = Lists.newArrayList(2, 3, 4);
        listTest(a);
        System.out.println(a);

    }

    public void listTest(ArrayList<Integer> a) {
        a = Lists.newArrayList(4);
        System.out.println("a = " + a);
    }



}
