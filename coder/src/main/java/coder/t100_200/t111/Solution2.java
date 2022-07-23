package coder.t100_200.t111;

import coder.common.TreeNode;

// 递归DFS
class Solution2 {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left) {
            return minDepth(root.right) + 1;
        }
        if (null == root.right) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}