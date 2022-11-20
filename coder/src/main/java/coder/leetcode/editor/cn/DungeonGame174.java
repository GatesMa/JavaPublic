package coder.leetcode.editor.cn;

import java.util.Arrays;

public class DungeonGame174 {

    // CheckStyle
    private final String time = "2022-11-20 18:52:06";

    public static void main(String[] args) {
        Solution solution = new DungeonGame174().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] memo;

        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
                return 0;
            }
            memo = new int[dungeon.length + 1][dungeon[0].length + 1];
            // init
            for (int i = 0; i < dungeon.length; i++) {
                Arrays.fill(memo[i], Integer.MAX_VALUE);
            }
            // dp[i][j] 从i，j到右下角需要的最小生命值
            return helper(dungeon, 0, 0);
        }

        public int helper(int[][] dungeon, int i, int j) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return Integer.MAX_VALUE;
            }
            // base case
            if (i == m - 1 && j == n - 1) {
                return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
            }

            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            int res = Math.min(helper(dungeon, i + 1, j), helper(dungeon, i, j + 1)) - dungeon[i][j];

            // 如果算出来是负的，说明我们只需要保证初始血量是1就行
            memo[i][j] = res <= 0 ? 1 : res;

            return memo[i][j];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}