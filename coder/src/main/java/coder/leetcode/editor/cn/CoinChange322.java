package coder.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange322 {

    // CheckStyle
    private final String time = "2022-09-09 16:57:11";

    public static void main(String[] args) {
        Solution solution = new CoinChange322().new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {

            int[] memo = new int[amount + 1];
            Arrays.fill(memo, Integer.MAX_VALUE);

            return coinChangeHelper(coins, amount, memo);
        }

        public int coinChangeHelper(int[] coins, int amount, int[] memo) {
            if (coins == null || coins.length == 0 || amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (memo[amount] != Integer.MAX_VALUE) {
                return memo[amount];
            }

            for (int coin : coins) {
                int sub = coinChangeHelper(coins, amount - coin, memo);
                if (sub == -1) {
                    continue;
                }
                memo[amount] = Math.min(memo[amount], sub + 1);
            }

            memo[amount] = memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

            return memo[amount];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}