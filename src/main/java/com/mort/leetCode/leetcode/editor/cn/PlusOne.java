//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组

package com.mort.leetCode.leetcode.editor.cn;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
//        int[] parm = {4,3,2,0};
//        int[] parm = {9};
//        solution.plusOne(parm);
        solution.reversal(851);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {

        int[] ret = new int[digits.length+1];
        int carry = 0 ;

        for (int i = digits.length - 1; i >= 0; i--) {

            int lastPlus = digits[i];

            if (i == digits.length - 1) {
                lastPlus = digits[i] + 1;
            } else {
                lastPlus += carry;
                if (carry == 1) {
                    carry = 0;
                }
            }

            if (lastPlus >= 10) {
                carry = 1;
                ret[i] = lastPlus % 10;
            }else{
                ret[i] = lastPlus;
            }
        }

        if(1 == carry){
            ret[0] = carry;
        }else{
            ret = Arrays.copyOfRange(ret, 0, ret.length - 1);
        }

        for (int i = 0; i < ret.length; i++) {
            System.out.println("ret["+i+"] = [" + ret[i] + "]");
        }

        return ret;
    }

    // 851转成158
    public int reversal(int a){

        int b = 0;
        while(a>0){
            int tmp =  a%10;
            b = b*10 + tmp;
            a= a/10;
        }
        return b;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}