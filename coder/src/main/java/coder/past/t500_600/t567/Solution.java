package coder.past.t500_600.t567;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    // owo helloworld
    public boolean checkInclusion(String s1, String s2) {

        // 左右指针
        int left = 0;
        int right = 0;

        // 窗口
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            // 只要长度满足要求就缩小窗口
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char c1 = s2.charAt(left);
                left++;

                if (window.containsKey(c1)) {
                    if (Objects.equals(window.get(c1), need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }

            }


        }

        return false;
    }
//
//    public static void main(String[] args) {
//
//        System.out.println(checkInclusion("owo", "helloworld"));
//
//    }


}


