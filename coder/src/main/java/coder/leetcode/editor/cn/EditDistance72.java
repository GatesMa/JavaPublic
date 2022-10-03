package coder.leetcode.editor.cn;

public class EditDistance72 {

    // CheckStyle
    private final String time = "2022-10-03 10:16:49";

    public static void main(String[] args) {
        Solution solution = new EditDistance72().new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }

    /**
     * if s1[i] == s2[j]:
     * 啥都别做（skip）
     * i, j 同时向前移动
     * else:
     * 三选一：
     * 插入（insert）
     * 删除（delete）
     * 替换（replace）
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDistance(String word1, String word2) {
            //memo = new int[word1.length() + 1][word2.length() + 1];
            // dp[i][j] = word1[0,i] word2[0,j] 的最小编辑距离
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                        continue;
                    }
                    dp[i][j] = min(
                            dp[i - 1][j] + 1, // 删
                            dp[i - 1][j - 1] + 1, // 改
                            dp[i][j - 1] + 1 // 增
                    );
                }
            }

            return dp[word1.length()][word2.length()];
        }

        int[][] memo;

        // word1[0,i] word2[0,j] 的最小编辑距离
        public int helper(String word1, int i, String word2, int j) {
            if (i < 0) {
                return j + 1;
            }
            if (j < 0) {
                return i + 1;
            }

            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            if (word1.charAt(i) == word2.charAt(j)) {
                return helper(word1, i - 1, word2, j - 1);
            }

            int sub = min(
                    helper(word1, i, word2, j - 1) + 1, // 插入
                    helper(word1, i - 1, word2, j) + 1,// 删除
                    helper(word1, i - 1, word2, j - 1) + 1 // 替换
            );
            memo[i][j] = sub;

            return sub;
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


}