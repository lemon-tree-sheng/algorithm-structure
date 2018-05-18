package org.sheng.as.leetcode;

/**
 * @author shengxingyue on 2018/5/8 16:50
 */
public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res += findSum(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 寻找包含 root 的路径中和为 sum 的路径总数
     *
     * @param root
     * @param sum
     * @return
     */
    private int findSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.val == sum) {
            res += 1;
        }
        res += findSum(root.left, sum - root.val);
        res += findSum(root.right, sum - root.val);
        return res;
    }
}
