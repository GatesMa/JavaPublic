package coder.leetcode.editor.cn;

public class MinimumPathSum64 {

    // CheckStyle
    private final String time = "2022-11-05 15:05:02";

    public static void main(String[] args) {
        Solution solution = new MinimumPathSum64().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            // dp[i][j]: 从0，0 到 i，j的最小值
            int[][] dp = new int[m + 1][n + 1];
            // base case
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}