package coder.leetcode.editor.cn;

public class TwoSum1 {

    // CheckStyle
    private final String time = "2022-08-31 10:46:48";

    public static void main(String[] args) {
        Solution solution = new TwoSum1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 

}