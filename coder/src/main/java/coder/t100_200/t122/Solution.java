package coder.t100_200.t122;

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

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];

    }

    public static void main(String[] args) {
        //输入：[7,1,5,3,6,4]
        // 输出：7
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
