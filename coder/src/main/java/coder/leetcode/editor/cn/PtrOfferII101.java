package coder.leetcode.editor.cn;

import java.util.Arrays;

public class PtrOfferII101 {

    // CheckStyle
    private final String time = "2022-10-30 20:32:24";

    public static void main(String[] args) {
        Solution solution = new PtrOfferII101().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }

            int sum = Arrays.stream(nums).sum();
            // 不能被2整除
            if (sum % 2 != 0) {
                return false;
            }

            sum = sum / 2;
            // 0 - 1背包，存在一个组合使得恰好拿走一半的物品
            // dp[i][j] = x 表示，对于前 i 个物品（i 从 1 开始计数），当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];

            // base case
            for (int i = 0; i <= nums.length; i++) {
                dp[0][i] = false;
            }
            for (int i = 0; i <= sum; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i <= nums.length; i++) {

                for (int j = 1; j <= sum; j++) {

                    if (j - nums[i] > 0) {
                        // 第i个物品的重量：nums[i - 1]
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }


                }

            }

            return dp[nums.length][sum];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}