//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//所谓“回文”是指顺读和倒读都一样的字符串。如“XYZYX”和“xyzzyx”都是回文。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
//假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
// Related Topics 哈希表

package leetCode.leetcode.editor.cn;

import java.util.HashSet;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        solution.longestPalindromeV2("abccccdd");
        solution.palindromeJudge("XYZYX");
        solution.palindromeJudge("xyzzyx");
        solution.longestPalindrome("abccccdd");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针 最大重复字符长度
        public int longestPalindromeV2(String s) {
            HashSet set = new HashSet();
            int max = 1;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = chars.length - 1; j >= i; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            return max;
        }

        //如“XYZYX”和“xyzzyx”都是回文。  回文字符判断
        public boolean palindromeJudge(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int n = length - 1;
            for (int i = 0; i <= n / 2; i++) {
                if (chars[i] != chars[n - i]) {
                    return false;
                }
            }
            return true;
        }

        public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (char c : s.toCharArray())
                count[c]++;

            int ans = 0;
            for (int v : count) {
                //偶数个重复的直接加  奇数个重复 1为0  大于1的奇数为 奇数下一个偶数 例如 3为2  相当于 v >> 1 << 1
                ans += v / 2 * 2;

                //如果有奇数个重复 切之前是偶数排列个 则在加1位长度
                if (v % 2 == 1 && ans % 2 == 0)
                    ans++;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}