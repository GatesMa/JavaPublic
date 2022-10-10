package coder.leetcode.editor.cn;

public class LongestPalindromicSubsequence516 {

    // CheckStyle
    private final String time = "2022-10-10 19:27:31";

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence516().new Solution();
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestPalindromeSubseq(String s) {
            int n = s.length();

            // dp[i][j] s[i,j]的最长回文子串，求dp[0,n-1]
            int[][] dp = new int[n + 1][n + 1];

            // base case
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[0][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}