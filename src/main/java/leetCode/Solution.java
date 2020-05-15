package leetCode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author:  lining17
 * Date :  2020-02-04
 */
public class Solution {


    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    //https://leetcode-cn.com/problems/two-sum/
    /*
    给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum

    * */
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int i = 0;
        int j = 0;


        while (i < nums.length) {
            while (j < nums.length) {
                if ((target == nums[i] + nums[j]) && (i != j)) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
                j++;
            }
            j = 0;
            i++;
        }

        return ret;
    }


    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 0; j < nums.length  ; j++) {
                if (nums[i] == nums[j] && j != i) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }
        return 0;

//        method 2
//        int ans = nums[0];
//        if (nums.length > 1) {
//            for (int i = 1; i < nums.length; i++) {
//               ans = ans ^ nums[i];  // 计算机异或 转为二进制运算同为0 异为1
//            }
//        }
//        return ans;
    }


    //无重复最长字符串

    /*
    *
    * 输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    * */
    static String noRepeatStr() {
//        String str = "asadafgsvhsds";
        String str = "pwwkew";
        char[] chars = str.toCharArray();
        String tmp = str.substring(0,1);
        int i;
        int j;
        for (i = 0; i < chars.length; i++) {
            for (j = i+1; j < chars.length; j++) {
                if (str.substring(i, j).contains(String.valueOf(chars[j]))) {
                    i++;
                    j = i;
                } else {
                    if (str.substring(i, j+1).length() > tmp.length()) {
                        tmp = str.substring(i, j+1);
                    }
                }
            }
        }
        System.out.printf(tmp);
        return tmp;
    }

    private int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;//记录最长子串的长度
        int end = 0, start = 0;//记录开始和结尾的下标
        Set<Character> set = new HashSet<>();//使用set容器不重复
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {//如果窗口右侧的字符已经存在
                set.remove(s.charAt(start++));//左侧窗口边界向右
            } else {
                set.add(s.charAt(end++));//如果窗口中无重复，窗口右侧向右滑动
                res = Math.max(res, end - start);//同时记录当前最大长度
            }
        }
        logger.info("{}, {} , {} , {}", res, end, start, set);
        return res;
    }

    @Test
    public void lengthOfLongestSubstringTest(){
        lengthOfLongestSubstring("abdsfsaadds");
    }

//    [1,2,5,6] [3,4,7,9] [1,2,3,4,5,6,7,9]
//    [1,2,3,4] [5,6,7,9] [1,2,3,4,5,6,7,9]
//    [1,5] [2,3,4,6,7,9] [1,2,3,4,5,6,7,9]
//    [1,2] [3,4,5,6,7,9] [1,2,3,4,5,6,7,9]
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
//        int count = nums1.length + nums2.length;
//        double media = (count + 1) / 2;
//        int allMediaInt = (int) Math.floor(media);
//        int n1media = (int) Math.floor((nums1.length + 1) / 2);
//        int n2media = (int) Math.floor((nums2.length + 1) / 2);
//        if (n1media + n2media > allMediaInt) {
//            return (nums1[n1media] + nums2[n2media]) / 2;
//        }
        List<Integer> ints = IntStream.of(nums1).boxed().collect(Collectors.toList());
        List<Integer> ints2 = IntStream.of(nums2).boxed().collect(Collectors.toList());

        ints.addAll(ints2);
        ints = ints.stream().sorted().collect(Collectors.toList());
        int listMedia = (int) Math.floor((ints.size() + 1) / 2) -1;
        double ret;
        if(ints.size()%2 != 0){
            ret = ints.get(listMedia);
        }else{
            ret = (double) (ints.get(listMedia) + ints.get(listMedia + 1)) / 2;
        }

        System.out.println(ret);
        return ret;
//        ints.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.intValue() - o2.intValue();
//            }
//        });

    }



    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,4};
//        int target = 6;
//        int[] ret = twoSum(nums, target);
//        System.out.println("args = [" + ret[0] + "  "+ ret[1] + "]");

        int[] nums = new int[]{2,4,4,2,3,3,3,1};
//        singleNumber(nums);
//        noRepeatStr();

        findMedianSortedArrays(null, null );

    }




}
