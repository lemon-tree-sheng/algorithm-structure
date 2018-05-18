package org.sheng.as.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengxingyue on 2018/5/7 21:28
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        List<String> lefts = binaryTreePaths(root.left);
        for (String left : lefts) {
            res.add(root.val + "->" + left);
        }
        List<String> rights = binaryTreePaths(root.right);
        for (String right : rights) {
            res.add(root.val + "->" + right);
        }
        return res;
    }

}
