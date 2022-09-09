package coder.leetcode.editor.cn;

import java.util.Arrays;

public class RussianDollEnvelopes354 {

    // CheckStyle
    private final String time = "2022-09-08 19:00:38";

    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes354().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));

        // [[1,1],[1,1],[1,1]]
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 这个题会超时
         *
         * @param envelopes
         * @return
         */
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            // 先按宽度升序排，再按高度降序排
            Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

            // 再LIS
            int[] dp = new int[envelopes.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < envelopes.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            return Arrays.stream(dp).max().getAsInt();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}