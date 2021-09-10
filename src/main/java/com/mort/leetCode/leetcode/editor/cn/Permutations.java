//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法

package com.mort.leetCode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1, 2, 3};
        solution.permute(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean [] usedFlag = new boolean[nums.length];
            recursion(new ArrayList<>(), result, nums , usedFlag);
            return result;
        }
        //递归+回溯
        private void recursion(List<Integer> tmp, List<List<Integer>> result, int[] nums , boolean [] usedFlag) {
            if (nums.length == tmp.size()) {
                result.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                // 排列  去掉就是组合
                if(usedFlag[i]){
                    continue;
                }else{
                    usedFlag[i] = true;
                }

                tmp.add(nums[i]);
                recursion(tmp, result, nums, usedFlag);
                tmp.remove(tmp.size() - 1);
                usedFlag[i] = false;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}