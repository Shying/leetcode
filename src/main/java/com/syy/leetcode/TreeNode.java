package com.syy.leetcode;

import apple.laf.JRSUIUtils;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode makeTreeNode(int[] nums) {
        int i = 0;
        int len = nums.length;
        TreeNode[] nodeArray = new TreeNode[len];
        while (i < len) {
            if(nums[i] == 0) {
                continue;
            }
            TreeNode cur = nodeArray[i];
            if (cur == null) {
                cur = new TreeNode(nums[i]);
                nodeArray[i] = cur;
            }
            int leftPos = 1;
            int rightPos = 2;
            if(i > 0){
                leftPos = (int)Math.pow(2, i) + 1;
                rightPos = (int)Math.pow(2, i) + 2;
            }

            if (leftPos < len) {
                if(nums[leftPos] > 0) {
                    cur.left = new TreeNode(nums[leftPos]);
                    nodeArray[leftPos] = cur.left;
                }
            }else {
                break;
            }
            if(rightPos < len) {
                if (nums[rightPos] > 0) {
                    cur.right = new TreeNode(nums[rightPos]);
                    nodeArray[rightPos] = cur.right;
                }
            }else {
                break;
            }
            i++;
        }
        return nodeArray[0];
    }
}
