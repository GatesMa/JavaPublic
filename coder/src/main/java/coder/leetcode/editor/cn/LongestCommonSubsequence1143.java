package coder.leetcode.editor.cn;

import java.util.Arrays;

public class LongestCommonSubsequence1143 {

    // CheckStyle
    private final String time = "2022-10-05 09:38:48";

    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence1143().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] memo;

        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null) {
                return 0;
            }

            memo = new int[text1.length() + 1][text2.length() + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MIN_VALUE);
            }

            return helper(text1, 0, text2, 0);
        }

        // text1[i,] text2[j,] 的最长公共子序列
        public int helper(String text1, int i, String text2, int j) {
            if (i == text1.length() || j == text2.length()) {
                return 0;
            }

            if (memo[i][j] != Integer.MIN_VALUE) {
                return memo[i][j];
            }

            if (text1.charAt(i) == text2.charAt(j)) {
                return helper(text1, i + 1, text2, j + 1) + 1;
            }

            int sub = Math.max(
                    helper(text1, i, text2, j + 1),
                    helper(text1, i + 1, text2, j)
            );

            memo[i][j] = sub;

            return sub;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}