//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
//
//
//
// 示例:
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
// Related Topics 字符串 回溯算法

package leetCode.leetcode.editor.cn;

import java.util.*;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
        solution.testMethod("1234");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> res = new ArrayList<>();
            // 如果长度不够，不搜索
            if (len < 4 || len > 12) {
                return res;
            }

            Deque<String> path = new ArrayDeque<>(4);
            int splitTimes = 0;
            dfs(s, len, splitTimes, 0, path, res);
            return res;
        }

        /**
         * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
         * 判断的同时顺便把类型转了
         *
         * @param s
         * @param left
         * @param right
         * @return
         */
        private int judgeIfIpSegment(String s, int left, int right) {
            int len = right - left + 1;

            // 大于 1 位的时候，不能以 0 开头
            if (len > 1 && s.charAt(left) == '0') {
                return -1;
            }

            // 转成 int 类型
            int res = 0;
            for (int i = left; i <= right; i++) {
                res = res * 10 + s.charAt(i) - '0';
            }

            if (res > 255) {
                return -1;
            }
            return res;
        }

        private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
            if (begin == len) {
                if (split == 4) {
                    res.add(String.join(".", path));
                }
                return;
            }

            // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
            if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (begin + i >= len) {
                    break;
                }

                int ipSegment = judgeIfIpSegment(s, begin, begin + i);
                if (ipSegment != -1) {
                    // 在判断是 ip 段的情况下，才去做截取
                    path.addLast(ipSegment + "");
                    dfs(s, len, split + 1, begin + i + 1, path, res);
                    path.removeLast();
                }
            }
        }

        public List<String> testMethod(String s) {
            List<String> ret = new ArrayList<>();
            char[] chars = s.toCharArray();
            char[] cloneChars = chars.clone();
            for (int i = 0; i < chars.length; i++) {
                for(int j = i ; j< chars.length ; j++){
                    char[] charsCopy = Arrays.copyOf(chars, chars.length);
                    charsCopy[i] = chars[j];
                    charsCopy[j] = chars[i];
                    String tmpS = Arrays.toString(charsCopy);
                    ret.add(tmpS);
                }
            }
            return ret;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)