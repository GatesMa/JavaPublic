package coder.past.t300_400.t322;

import java.util.Arrays;

/**
 * Solution3
 *
 * @author by gatesma on 2022/2/27.
 */
// 迭代
class Solution3 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        // 这里只能设置为 amount + 1 - Integer.MAX_VALUE - 1的值，如果设置为Integer.MAX_VALUE的话，+1之后会变成负数
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        new Solution3().coinChange(new int[]{2}, 3);
    }

}