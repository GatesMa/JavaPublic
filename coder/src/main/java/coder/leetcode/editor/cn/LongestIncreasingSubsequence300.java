package coder.leetcode.editor.cn;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {

    // CheckStyle
    private final String time = "2022-08-31 14:56:47";

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence300().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            if (nums == null) {
                return 0;
            }
            if (nums.length <= 1) {
                return nums.length;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(max, dp[i]);
                    }
                }
            }


            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}