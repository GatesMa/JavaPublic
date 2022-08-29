package coder.t300_400.t309;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        // 处理只有一天交易日期
        if (prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}
