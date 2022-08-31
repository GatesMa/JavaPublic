package coder.past.t100_200.t121;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // // dp[i][0] 第i天，无股票，dp[i][1] 第i天，有股票
        // int dp_i_0 = 0, dp_i_1 = -prices[0];
        // for (int i = 1; i < n; i++) {
        //     dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        //     dp_i_1 = Math.max(dp_i_1, -prices[i]);
        // }

        // return dp_i_0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i][1] = Math.max(dp[i][1], -prices[i]);
        }

        return dp[n - 1][0];

    }

    public static void main(String[] args) {
        //输入：[7,1,5,3,6,4]
        // 输出：5
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
