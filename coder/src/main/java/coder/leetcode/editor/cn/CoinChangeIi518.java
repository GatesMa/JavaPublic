package coder.leetcode.editor.cn;

public class CoinChangeIi518 {

    // CheckStyle
    private final String time = "2022-10-30 21:02:30";

    public static void main(String[] args) {
        Solution solution = new CoinChangeIi518().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 完全背包问题，物品数量无限
         */
        public int change(int amount, int[] coins) {

            // dp[i][j] 使用0-i的硬币，j的容量。有dp[i][j]种方法
            int[][] dp = new int[coins.length + 1][amount + 1];
            // base case
            for (int i = 0; i <= coins.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i <= amount; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i <= coins.length; i++) {

                for (int j = 1; j <= amount; j++) {

                    if (j - coins[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }

                }

            }

            return dp[coins.length][amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}