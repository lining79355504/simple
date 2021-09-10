//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
// 说明：
//
//
// 给定 n 的范围是 [1, 9]。
// 给定 k 的范围是[1, n!]。
//
//
// 示例 1:
//
// 输入: n = 3, k = 3
//输出: "213"
//
//
// 示例 2:
//
// 输入: n = 4, k = 9
//输出: "2314"
//
// Related Topics 数学 回溯算法

package com.mort.leetCode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        solution.getPermutation(4, 9);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {

        boolean [] used = new boolean[n+1];
        StringBuffer result = new StringBuffer();
        dfs(n, k, result, new ArrayList<>(), new ArrayList<>(), used);

//        List<Integer> result = new ArrayList<>();
//        dfs(n, k, result, new ArrayList<>(), new ArrayList<>(), used);
        return result.toString();
    }

        void dfs(int n, int k, StringBuffer result, List<Integer> tmp, List<List<Integer>> allList, boolean[] used) {
            if (n == tmp.size()) {
                allList.add(new ArrayList<>(tmp));
                if (allList.size() == k) {
                    for (Integer integer : tmp) {
                        result.append(integer);
                    }
                }
                return;
            }

            for (int i = 1; i <= n; i++) {

                if (used[i - 1]) {
                    continue;
                } else {
                    tmp.add(i);
                    used[i - 1] = true;
                }
                dfs(n, k, result, tmp, allList, used);
                tmp.remove(tmp.size() - 1);
                used[i - 1] = false;
            }
        }

//        void dfs(int n, int k, List<Integer> result, List<Integer> tmp, List<List<Integer>> allList, boolean [] used) {
//            if (n == tmp.size()) {
//                allList.add(new ArrayList<>(tmp));
//                if (allList.size() == k) {
//                    result.addAll(new ArrayList<>(tmp));
//                }
//                return;
//            }
//
//            for (int i = 1; i <= n; i++) {
//                if (used[i - 1]) {
//                    continue;
//                } else {
//                    tmp.add(i);
//                    used[i - 1] = true;
//                }
//
//                dfs(n, k, result, tmp, allList, used);
//                tmp.remove(tmp.size() - 1);
//                used[i-1] = false;
//            }
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}