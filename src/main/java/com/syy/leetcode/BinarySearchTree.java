package com.syy.leetcode;
import java.util.*;

public class BinarySearchTree {

    public List<Integer> scanSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        if (root.left != null) {
            nums.addAll(scanSmallest(root.left, k));
        }
        nums.add(root.val);
        if (nums.size() >= k) {
            return nums;
        }
        if (root.right != null) {
            nums.addAll(scanSmallest(root.right, k - nums.size()));
        }
        return nums;
    }


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = scanSmallest(root, k);
        if (k <= nums.size()) {
            return nums.get(k - 1); 
        }
        return -1;
    }



}
