package coder.t100_200.t188;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    public static int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];

    }

    public static void main(String[] args) {
        // 输入：k = 2, prices = [2,4,1]
        // 输出：2
        // 输入：k = 2, prices = [3,2,6,5,0,3]
        // 输出：7
        System.out.println(maxProfit(1, new int[]{1, 2}));
    }
}
