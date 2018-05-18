package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/7 15:35
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
