//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

package com.mort.leetCode.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
//        System.out.println("result = [" + solution.longestPalindrome("aaabaaaa") + "]");
        System.out.println("result = [" + solution.longestPalindrome("cbbd") + "]");
//        System.out.println("result = [" + solution.longestPalindrome("ac") + "]");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public String longestPalindrome(String s) {
//
//            if(2 > s.length()){
//                return s;
//            }
//
//            if (2 ==  s.length()) {
//                if(s.charAt(0) == s.charAt(1)){
//                    return s;
//                }
//            }
//
//            char[] chars = s.toCharArray();
//            int length = chars.length;
//            int maxLength = 1;
//            int from = 0;
//            int end = 0;
//            boolean dp[][] = new boolean[length][length];
//
//            for (int j = 0; j < chars.length; j++) {
//                dp[j][j] = true;
//            }
//
//            for (int j = 0; j < chars.length; j++) {
//                for (int i = 0; i < j; i++) {
//                    if (chars[i] == chars[j]) {
//                        if (dp[i + 1][j - 1]) {
//                            dp[i][j] = true;
//                            if (j - i + 1 > maxLength) {
//                                maxLength = Math.max(j - i + 1, maxLength);
//                                from = i;
//                                end = j;
//                            }
//                        }
//                    }
//                }
//            }
//
//            return s.substring(from, end + 1);
//        }


        public String longestPalindrome(String s) {
            if (s.isEmpty()) {
                return s;
            }
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int left = 0;
            int right = 0;
            for (int i = n - 2; i >= 0; i--) {
                dp[i][i] = true;
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) &&( j-i<3||dp[i+1][j-1]);//小于3是因为aba一定是回文
                    if(dp[i][j]&&right-left<j-i){
                        left=i;
                        right=j;
                    }
                }
            }
            return s.substring(left,right+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}