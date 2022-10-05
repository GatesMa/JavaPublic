package coder.leetcode.editor.cn;

public class MinimumAsciiDeleteSumForTwoStrings712 {

    // CheckStyle
    private final String time = "2022-10-05 10:16:29";

    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStrings712().new Solution();
        System.out.println(solution.minimumDeleteSum("ccaccjp", "fwosarcwge"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 备忘录的方式
        // int[][] memo;
        //
        // public int minimumDeleteSum(String text1, String text2) {
        //     if (text1 == null || text2 == null) {
        //         return 0;
        //     }
        //
        //     memo = new int[text1.length() + 1][text2.length() + 1];
        //     for (int[] ints : memo) {
        //         Arrays.fill(ints, Integer.MAX_VALUE);
        //     }
        //
        //     return helper(text1, 0, text2, 0);
        // }
        //
        // // text1[i,] text2[j,] 的最长公共子序列
        // public int helper(String text1, int i, String text2, int j) {
        //     if (i == text1.length()) {
        //         // text1到头了，那么text2剩下的都需要删除
        //         int res = 0;
        //         for (; j < text2.length(); j++) {
        //             res += text2.charAt(j);
        //         }
        //         return res;
        //     }
        //     if (j == text2.length()) {
        //         // text2到头了，那么text1剩下的都需要删除
        //         int res = 0;
        //         for (; i < text1.length(); i++) {
        //             res += text1.charAt(i);
        //         }
        //         return res;
        //     }
        //
        //     if (memo[i][j] != Integer.MAX_VALUE) {
        //         return memo[i][j];
        //     }
        //
        //     if (text1.charAt(i) == text2.charAt(j)) {
        //         return helper(text1, i + 1, text2, j + 1);
        //     }
        //
        //     int sub = Math.min(
        //             helper(text1, i, text2, j + 1) + text2.charAt(j),
        //             helper(text1, i + 1, text2, j) + text1.charAt(i)
        //     );
        //
        //     memo[i][j] = sub;
        //
        //     return sub;
        // }

        // dp数组的方式，注意base case的处理
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            if (m == 0 || n == 0) {
                return 0;
            }

            // dp[i][j] word1[0..i-1] word2[0..j-1] LCS
            int[][] dp = new int[m + 1][n + 1];

            // 这里多了一步，base case 的处理
            for (int i = 1; i <= m; i++) {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
            }
            for (int i = 1; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }
                }
            }

            return dp[m][n];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}