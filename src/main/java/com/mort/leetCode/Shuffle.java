package com.mort.leetCode;

/*随机打乱字符  高效
加权轮询时 为加权后的数据乱序提供支持*/


import java.util.Arrays;
import java.util.List;

public class Shuffle {

    public static void main(String[] args) {

        // 0 1 2 3 4 5 6 7 8 9
        String[] array = new String[10];
        List<String> strings = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        array = (String[]) strings.toArray();

        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            int random = (int) (Math.random() * (length - i));
            String tmp = array[i];
            array[i] = array[random];
            array[random] = tmp;
        }

        System.out.println("args = " + Arrays.deepToString(array));

    }
}
