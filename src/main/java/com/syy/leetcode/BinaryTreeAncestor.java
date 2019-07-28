package com.syy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAncestor {
    private TreeNode ans = null;

    public boolean searchNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = this.searchNode(root.left, p, q) ? 1 : 0;
        int right = this.searchNode(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1: 0;
        if (left + right + mid >= 2) {
            this.ans = root;
        }
        return left + right + mid > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchNode(root, p, q);
        return this.ans;
    }
}

class BinaryTreeAncestorLong2 {

    public List<Integer> searchNodePath(TreeNode root, int value) {
        List<Integer> path = new ArrayList<Integer>();
        if (root == null) {
            return path;
        }

        if (root.val == value) {
            path.add(root.val);
            return path;
        }
        if (root.left != null) {
            List<Integer> leftPath = searchNodePath(root.left, value);
            if (leftPath != null && leftPath.size() > 0) {
                path.add(root.val);
                path.addAll(leftPath);
                return path;
            }
        }
        if (root.right != null) {
            List<Integer> rightPath = searchNodePath(root.right, value);
            if (rightPath != null && rightPath.size() > 0) {
                path.add(root.val);
                path.addAll(rightPath);
                return path;
            }
        }
        return path;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pPath = searchNodePath(root, p.val);
        printList(pPath);
        List<Integer> qPath = searchNodePath(root, q.val);
        printList(qPath);
        int i = 0;
        for (; i < Math.min(pPath.size(), qPath.size()); i++) {
            if (pPath.get(i).intValue() != qPath.get(i).intValue()) {
                break;
            }
        }
        if (i == 0) {
            return null;
        }
        return new TreeNode(pPath.get(i - 1));
    }

    public static void printList(List<Integer> array) {
        for(Integer v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTreeNode(new int[] {1, 2, 3, 4, 5});
        BinaryTreeAncestorLong2 obj = new BinaryTreeAncestorLong2();
        List<Integer> pPath = obj.searchNodePath(root, 4);
        printList(pPath);
        List<Integer> qPath = obj.searchNodePath(root, 5);
        printList(qPath);
        TreeNode v = obj.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));
        System.out.println(v.val);
    }
}

/**
 * 超出时间限制的方案
 */
class BinaryTreeAncestorLone {

    public List<TreeNode> scan(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        if (root == null) {
            return nodeList;
        }

        nodeList.add(root);
        int cur = 0;
        int max = 1;
        while (cur < max) {
            TreeNode node = nodeList.get(cur);
            if (node != null) {
                nodeList.add(node.left);
                if (node.left != null) {
                    max = nodeList.size();
                }
                nodeList.add(node.right);
                if (node.right != null) {
                    max = nodeList.size();
                }
            }else {
                nodeList.add(null);
                nodeList.add(null);
            }
            cur++;
        }
        return nodeList;
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        List<TreeNode> array = scan(root);

        int pI = array.indexOf(p);
        int qI = array.indexOf(q);
        int smallI = pI;
        int bigI = qI;
        if (pI > qI) {
            smallI = qI;
            bigI = pI;
        }
        // System.out.println("small " + smallI + " " + bigI);
        while (smallI > 0 && bigI > 0 && smallI != bigI) {
            while (smallI < bigI) {
                bigI = (bigI - 1) / 2;
                // System.out.println("small " + smallI + " " + bigI);
            }
            if (smallI == bigI) {
                return array.get(smallI);
            }
            int temp = smallI;
            smallI = bigI;
            bigI = temp;
            // System.out.println("change " + smallI + " " + bigI);

        }
        return root;
    }

    public void printTreeNode(List<TreeNode> array) {
        for (TreeNode node : array) {
            if (node != null) {
                 System.out.print(node.val + ", ");
            }else {
                 System.out.print("null, ");
            }
        }
        System.out.println();
    }
}