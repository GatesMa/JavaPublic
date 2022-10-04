package coder.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {

    // CheckStyle
    private final String time = "2022-08-31 14:56:47";

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence300().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // dp[i] 0 - i 的最长上升子序列
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            return Arrays.stream(dp).max().getAsInt();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}