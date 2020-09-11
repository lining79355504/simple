//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法

package leetCode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PermutationsIi {

    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1, 1, 2};
        solution.permuteUnique(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            boolean[] usedFlag = new boolean[nums.length];
            recursion(new ArrayList<>(), result, nums, usedFlag);
            return result;
        }

        //递归+回溯
        private void recursion(List<Integer> tmp, List<List<Integer>> result, int[] nums, boolean[] usedFlag) {
            if (nums.length == tmp.size()) {
                if (result.contains(tmp)) {
                    return;
                }
                result.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                // 排列  去掉就是组合
                if (usedFlag[i]) {
                    continue;
                } else {
                    usedFlag[i] = true;
                }

                tmp.add(nums[i]);
                recursion(tmp, result, nums, usedFlag);
                tmp.remove(tmp.size() - 1);
                usedFlag[i] = false;
            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
