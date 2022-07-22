package coder.t300_400.t322;

// 暴力递归，超时
class Solution {
    

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub != -1) {
                res = Math.min(res, sub + 1);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}





