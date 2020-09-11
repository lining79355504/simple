//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
// 示例:
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// Related Topics 数组

//00 01 02 12 22 21 20 11 12
//
package leetCode.leetcode.editor.cn;
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[][] generateMatrix(int n) {
            int num = 1, max = n * n;
            int[][] ret = new int[n][n];
            int l = 0, r = n - 1, t = 0, b = n - 1;

            while (num <= max) {

                for (int i = l; i <= r; i++) ret[t][i] = num++;
                t++;
                for (int i = t; i <= b; i++) ret[i][r] = num++;
                r--;
                for (int i = r; i >= l; i--) ret[b][i] = num++;
                b--;
                for (int i = b; i >= t; i--) ret[i][l] = num++;
                l++;
            }
            return ret;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}