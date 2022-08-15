package coder.t1_100.t76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author by gatesma.
 */
class Solution {

    /**
     * s = "ADOBECODEBANC", t = "ABC"
     */
    public static String minWindow(String s, String t) {
        assert s != null;

        // 左右指针
        int left = 0;
        int right = 0;

        // 窗口信息
        int start = 0;
        int len = Integer.MAX_VALUE;

        // 窗口内的数据
        Map<Character, Integer> window = new HashMap<>();
        // 需要的数据
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.toCharArray().length; i++) {
            Integer cnt = need.getOrDefault(t.charAt(i), 0);
            need.put(t.charAt(i), cnt + 1);
        }

        // 满足要求的字符数
        int valid = 0;

        while (right < s.length()) {
            // 当前处理的字符
            char c = s.charAt(right);
            right++;
            // window 添加数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果满足全部的数据
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 记录当前窗口信息
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 左侧缩小
                char sch = s.charAt(left);
                left++;

                if (need.containsKey(sch)) {
                    if (Objects.equals(window.get(sch), need.get(sch))) {
                        valid--;
                    }
                    window.put(sch, window.get(sch) - 1);
                }
            }


        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
