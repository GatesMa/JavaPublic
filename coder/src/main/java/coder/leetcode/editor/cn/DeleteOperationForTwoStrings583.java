package coder.leetcode.editor.cn;

public class DeleteOperationForTwoStrings583 {

    // CheckStyle
    private final String time = "2022-10-05 09:59:18";

    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings583().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDistance(String word1, String word2) {
            if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) {
                return 0;
            }
            // 求最长公共子序列长度
            int lcs = lcs(word1, word2);
            return word1.length() + word2.length() - 2 * lcs;
        }


        // LCS
        public int lcs(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m == 0 || n == 0) {
                return 0;
            }

            // dp[i][j] word1[0..i-1] word2[0..j-1] LCS
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[m][n];
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


}