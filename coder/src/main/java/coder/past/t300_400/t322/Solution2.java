package coder.past.t300_400.t322;

/**
 * Solution2
 *
 * @author by gatesma on 2022/2/27.
 */
// 备忘录递归
class Solution2 {

    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        return coinChangeHelper(coins, amount);
    }

    private int coinChangeHelper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChangeHelper(coins, amount - coin);
            if (sub != -1) {
                res = Math.min(res, sub + 1);
            }
        }
        
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}