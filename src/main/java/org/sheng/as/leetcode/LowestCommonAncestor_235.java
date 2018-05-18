package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/8 17:34
 * 几种情况：
 * p < root && q > root => root
 * p < root && q < root => root -> left
 * p > root && q > root => root -> right
 * p == root => root
 * q == root => root
 */
public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
