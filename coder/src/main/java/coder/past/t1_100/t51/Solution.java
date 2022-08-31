package coder.past.t1_100.t51;

import java.util.ArrayList;
import java.util.List;

// 自己的
public class Solution {

    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        // 初始化棋盘
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb);
        }

        // 回溯
        backtrack(board, n, 0);
        return res;
    }

    public void backtrack(List<StringBuilder> board, int n, int row) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (StringBuilder str : board) {
                tmp.add(str.toString());
            }
            res.add(tmp);
            return;
        }

        // 填第row行
        for (int i = 0; i < n; i++) {
            if (!vaild(board, row, i)) {
                continue;
            }
            board.get(row).setCharAt(i, 'Q');
            backtrack(board, n, row + 1);
            board.get(row).setCharAt(i, '.');
        }

    }

    public boolean vaild(List<StringBuilder> board, int row, int col) {
        int n = board.size();
        // 正上方
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}


