package coder.past.t400_500.t438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Solution
 *
 * @author by gatesma.
 */
public class Solution {

    //输入: s = "abab", p = "ab"
    //输出: [0,1,2]
    public static List<Integer> findAnagrams(String s, String p) {
        //  左右指针
        int left = 0;
        int right = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int valid = 0;
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // result
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;

            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (Objects.equals(window.get(r), need.get(r))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char l = s.charAt(left);
                left++;

                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }

            }


        }

        return res;
    }

    // public static void main(String[] args) {
    //     System.out.println(findAnagrams("abab", "ab"));
    // }

}
