package com.mort.airthmethic.dp;

/**
 * @author mort
 * @Description
 * @date 2022/11/20
 **/
public class DpTest {


    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
//        int i;
//        int j;
//        int max = 0;

//        int i, j, max = 0;
        int i, j, max = nums[0];

        for (i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (j = i; j < nums.length; j++) {
                tmp += nums[j];
                max = Math.max(tmp, max);
            }
        }
        return max;

    }


    /**
     *   作者：力扣官方题解
     *     链接：https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
    思路和算法
     *
     * 假设 nums\textit{nums}nums 数组的长度是 nnn，下标从 000 到 n−1n-1n−1。
     *
     * 我们用 f(i)f(i)f(i) 代表以第 iii 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
     *
     * max⁡0≤i≤n−1{f(i)}\max_{0 \leq i \leq n-1} \{ f(i) \}
     * 0≤i≤n−1
     * max
     * ​
     *  {f(i)}
     * 因此我们只需要求出每个位置的 f(i)f(i)f(i)，然后返回 fff 数组中的最大值即可。那么我们如何求 f(i)f(i)f(i) 呢？我们可以考虑 nums[i]\textit{nums}[i]nums[i] 单独成为一段还是加入 f(i−1)f(i-1)f(i−1) 对应的那一段，这取决于 nums[i]\textit{nums}[i]nums[i] 和 f(i−1)+nums[i]f(i-1) + \textit{nums}[i]f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     *
     * f(i)=max⁡{f(i−1)+nums[i],nums[i]} f(i) = \max \{ f(i-1) + \textit{nums}[i], \textit{nums}[i] \}
     * f(i)=max{f(i−1)+nums[i],nums[i]}
     * 不难给出一个时间复杂度 O(n)O(n)O(n)、空间复杂度 O(n)O(n)O(n) 的实现，即用一个 fff 数组来保存 f(i)f(i)f(i) 的值，用一个循环求出所有 f(i)f(i)f(i)。考虑到 f(i)f(i)f(i) 只和 f(i−1)f(i-1)f(i−1) 相关，于是我们可以只用一个变量 pre\textit{pre}pre 来维护对于当前 f(i)f(i)f(i) 的 f(i−1)f(i-1)f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)O(1)O(1)，这有点类似「滚动数组」的思想。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     *
     * O(n)
     */
    public int maxSubArrayDP(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }



}
