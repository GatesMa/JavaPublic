package coder.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {

    // CheckStyle
    private final String time = "2022-11-05 13:43:13";

    public static void main(String[] args) {
        Solution solution = new TargetSum494().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }


    /**
     * 回溯解法一
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {

        private int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            backtrack(nums, target, 0, 0);
            return res;
        }

        public void backtrack(int[] nums, int target, int curSum, int pos) {
            if (pos == nums.length) {
                if (curSum == target) {
                    res++;
                }
                return;
            }

            // 每一个数字两种选择

            curSum += nums[pos];
            backtrack(nums, target, curSum, pos + 1);
            curSum -= nums[pos];

            curSum -= nums[pos];
            backtrack(nums, target, curSum, pos + 1);
            curSum += nums[pos];
        }


    }

    /**
     * 回溯带备忘录
     */
    class Solution2 {


        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }

            return backtrack(nums, target, 0);
        }

        private Map<String, Integer> memo = new HashMap<>();

        public int backtrack(int[] nums, int remain, int pos) {
            if (pos == nums.length) {
                if (remain == 0) {
                    return 1;
                }
                return 0;
            }

            String key = pos + "," + remain;

            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // 每一个数字两种选择
            int res = backtrack(nums, remain - nums[pos], pos + 1)
                    + backtrack(nums, remain + nums[pos], pos + 1);

            memo.put(key, res);

            return res;
        }


    }

    /**
     * 背包解法
     * 综上，可以推出 sum(A) = (target + sum(nums)) / 2，
     * 也就是把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2？
     */
    class Solution {


        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            int sum = Arrays.stream(nums).sum();
            if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
                return 0;
            }

            return subSets(nums, (sum + target) / 2);
        }


        public int subSets(int[] nums, int sum) {

            // dp[i][j] 0-i,容量为j 恰好装满的解法
            int[][] dp = new int[nums.length + 1][sum + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= nums.length; i++) {
                // 这里从0开始，因为容量为0，不一定只有一种解法
                for (int j = 0; j <= sum; j++) {
                    if (j < nums[i - 1]) {
                        // 装不下
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 装或不装
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][sum];
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)


}