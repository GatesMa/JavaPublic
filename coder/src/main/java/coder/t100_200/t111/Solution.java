package coder.t100_200.t111;

import coder.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

// BFS
class Solution {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null == node.right && null == node.left) {
                    return depth;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }


}