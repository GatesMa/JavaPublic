package coder.leetcode.editor.cn;

import java.util.Arrays;

public class MinimumFallingPathSum931 {

    // CheckStyle
    private final String time = "2022-10-03 09:30:40";

    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSum931().new Solution();
        // [[-19,57],[-40,-5]]
        System.out.println(solution.minFallingPathSum(new int[][]{new int[]{-19, 57}, new int[]{-40, -5}}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int len = 0;
        public int[][] memo;

        public int minFallingPathSum(int[][] matrix) {
            len = matrix.length;
            memo = new int[len][len];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            if (len <= 0) {
                return 0;
            }

            int[][] dp = new int[len][len];

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, helper(matrix, len - 1, i));
            }

            return min;

        }

        /**
         * 到达i， j位置的最小下降值
         */
        public int helper(int[][] matrix, int i, int j) {
            if (i < 0 || j < 0 || i >= len || j >= len) {
                return Integer.MAX_VALUE;
            }
            // base， 已经在第0行
            if (i == 0) {
                return matrix[i][j];
            }
            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            int sub = matrix[i][j] + Math.min(
                    helper(matrix, i - 1, j - 1),
                    Math.min(
                            helper(matrix, i - 1, j),
                            helper(matrix, i - 1, j + 1)));
            memo[i][j] = sub;

            return sub;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


}