package coder.leetcode.editor.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {

    // CheckStyle
    private final String time = "2022-10-23 19:14:57";

    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum416().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            // 0 - 1背包问题
            // 能不能找到一个组合使得sum/2的背包容量，恰好装满
            int sum = Arrays.stream(nums).sum();
            // 不能平分
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;
            }
            for (int i = 0; i <= sum; i++) {
                dp[0][i] = false;
            }

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= sum; j++) {

                    // 背包容量不足
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }

                }
            }

            return dp[nums.length][sum];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}