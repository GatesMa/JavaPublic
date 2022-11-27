package coder.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FreedomTrail514 {

    // CheckStyle
    private final String time = "2022-11-20 19:24:17";

    public static void main(String[] args) {
        Solution solution = new FreedomTrail514().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] memo;
        Map<Character, List<Integer>> chIdx = new HashMap<>();

        public int findRotateSteps(String ring, String key) {
            if (ring == null || key == null || key.length() == 0) {
                return 0;
            }

            memo = new int[ring.length() + 1][key.length() + 1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], Integer.MAX_VALUE);
            }

            // 记录key中每一个字符的索引
            for (int i = 0; i < ring.toCharArray().length; i++) {
                char c = ring.toCharArray()[i];
                if (!chIdx.containsKey(c)) {
                    chIdx.put(c, new LinkedList<>());
                }
                chIdx.get(c).add(i);
            }

            return helper(ring, 0, key, 0);
        }


        // dp[i,j]: 当前指针在i的位置，要寻找key[j,...]的字符需要多少步
        public int helper(String ring, int i, String key, int j) {
            if (j == key.length()) {
                return 0;
            }
            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            int res = Integer.MAX_VALUE;
            // 遍历所有的字符索引
            for (Integer idx : chIdx.get(key.toCharArray()[j])) {

                // 当前字符到达idx的最短距离
                int delta = Math.abs(i - idx);

                // 也可以顺逆时针
                delta = Math.min(delta, Math.abs(ring.length() - delta));

                // 子问题的解
                int sub = helper(ring, idx, key, j + 1);

                res = Math.min(res, sub + delta + 1);
            }

            memo[i][j] = res;

            return res;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


}