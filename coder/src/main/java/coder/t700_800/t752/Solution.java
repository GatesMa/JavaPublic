package coder.t700_800.t752;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        int step = 0;

        // 记录已经走过的密码
        Set<String> pathSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每一个密码，4位数字都可以向上或向下
            for (int i = 0; i < size; i++) {
                String pass = queue.poll();
                if (deadSet.contains(pass) || pathSet.contains(pass)) {
                    continue;
                }
                if (target.equals(pass)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    queue.offer(minusOne(pass, j));
                    queue.offer(plusOne(pass, j));
                }
                pathSet.add(pass);
            }
            step++;
        }
        return -1;
    }

    // 将密码锁的一位向下转
    public String minusOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '0') {
            chs[i] = '9';
        } else {
            chs[i] -= 1;
        }
        return new String(chs);
    }

    // 将密码锁的一位向上转
    public String plusOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '9') {
            chs[i] = '0';
        } else {
            chs[i] += 1;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
    }


}