package com.syy.leetcode;
import java.util.*;

public class BinarySearchTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        if (p.val < rootVal && q.val < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        }else if (p.val > rootVal && q.val > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }

}
