package com.mort.airthmethic;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author mort
 * @Description
 * @date 2021/4/27
 **/
public class CommSolution {

     private static final Logger logger = LoggerFactory.getLogger(CommSolution.class);
    /**
     * 二进制手表
     * 参照 https://github.com/doocs/leetcode/tree/main/solution/0400-0499/0401.Binary%20Watch
     * 输入: n = 1
     * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     *
     * Integer.bitCount 返回integer 中位数为1的个数
     */

    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    ret.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return ret;
    }


    @Test
    public void test(){
        List<String> strings = readBinaryWatch(3);
        logger.info("info {}", strings);
    }





    /**
     * 用栈实现队列功能的 pop push
     * @param <T>
     */
    public class StackQueue<T> {
        Stack in = new Stack<T>();
        Stack out = new Stack<T>();
        public void push(T item) {
            in.push(item);
        }

        public T pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return (T) out.pop();
        }
    }

    @Test
    public void StackQueueTest(){
        StackQueue stackQueue = new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        stackQueue.pop();
    }

    /**
     * 罗马数字转数字
     *
     * 题目描述
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     *
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     *
     */

    public int romanToInt(String romanStr) {
        int result = 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int length = romanStr.length();
        for (int i = 0; i < length; i++) {
            int ans = 0;
            if ((i + 1 < length) && (romanMap.get(romanStr.charAt(i)) <= romanMap.get(romanStr.charAt(i + 1)))) {
                ans = -romanMap.get(romanStr.charAt(i));
            } else {
                ans = romanMap.get(romanStr.charAt(i));
            }
            result += ans;
        }
        return result;


//        int ans = 0;
//        int n = romanStr.length();
//        for (int i = 0; i < n; ++i) {
//            int value = romanMap.get(romanStr.charAt(i));
//            if (i < n - 1 && value < romanMap.get(romanStr.charAt(i + 1))) {
//                ans -= value;
//            } else {
//                ans += value;
//            }
//        }
//        return ans;
    }

    @Test
    public void romanTest(){
        System.out.println(romanToInt("V"));
        Lists.newArrayList(new HashSet<>());

    }


    /**
     *
     * 题目描述
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。
     * 示例 1：
     * 输入：nums = [4,14,2]
     * 输出：6
     * 解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
     *
     * 提示：
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^9
     *
     * @return
     */
    public int testHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int countHigh = 0;
            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] >> i & 1) == 1) {
                    countHigh++;
                }
            }
            ans += countHigh * (nums.length - countHigh);
        }
        return ans;
    }

    @Test
    public void testHammingDistance() {
        int[] nums = {4, 14, 2};
        int hammingDistance = testHammingDistance(nums);
        System.out.println(hammingDistance);
        hammingDistance(1, 4);
    }


    /**
     * 两个整数的hamming距离    https://www.jianshu.com/p/aa9ea73eaf2d
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
