package coder.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSubarray53 {

    // CheckStyle
    private final String time = "2022-10-04 19:43:50";

    /**
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray53().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // dp[i] : 以nums[i]结尾的最大子序列长度
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }

            return Arrays.stream(dp).max().getAsInt();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}