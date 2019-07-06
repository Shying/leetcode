package com.syy.leetcode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = this.maxDepth(root.left);
        }
        if (root.right != null) {
            right = this.maxDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();
        TreeNode node = TreeNode.makeTreeNode(new int[] {3,9,20,0,0,15,7});
        int ret = obj.maxDepth(node);
        System.out.println(ret);
    }
}
