package coder.t100_200.t123;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
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

        return dp[n - 1][2][0];

    }

    public static void main(String[] args) {
        // 输入：prices = [3,3,5,0,0,3,1,4]
        // 输出：6
        System.out.println(maxProfit(new int[]{8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
