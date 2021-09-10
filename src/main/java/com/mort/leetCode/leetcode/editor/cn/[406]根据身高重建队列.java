//package com.mort.leetCode.leetcode.editor.cn;//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
////重建这个队列。
////
//// 注意：
////总人数少于1100人。
////
//// 示例
////
////
////输入:
////[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
////
////输出:
////[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
////
//// Related Topics 贪心算法
//// 👍 572 👎 0
//
//
//import java.util.Arrays;
//import java.util.Comparator;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[][] reconstructQueue(int[][] people) {
////        for(int i = 0 ; i< people.length; i++){
////
////
////
////        }
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] != o2[0]) {
//                    return o1[0] - o2[0];
//                } else {
//                    return o2[1] - o1[1];
//                }
//            }
//        });
//
//        int length = people.length;
//        int[][] ans = new int[length][];
//        for (int i = 0; i< length; i++){
//
//        }
//    return ans;
//    }
//
//    public static void main(String[] args) {
//        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//        Solution solution = new Solution();
//        solution.reconstructQueue(people);
//    }
//
//}
////leetcode submit region end(Prohibit modification and deletion)
