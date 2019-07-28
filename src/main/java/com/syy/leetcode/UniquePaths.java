package com.syy.leetcode;

public class UniquePaths {
    public int uniquePathsRecursive(int m, int n, int[][] paths) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int right = 0;
        if (paths[m][n - 1] > 0) {
            right = paths[m][n - 1];
        } else {
            right = uniquePathsRecursive(m, n - 1, paths);
            paths[m][n - 1] = right;
        }
        int down = 0;
        if (paths[m - 1][n] > 0) {
            down = paths[m - 1][n];
        } else {
            down = uniquePathsRecursive(m - 1, n, paths);
            paths[m - 1][n] = down;
        }
        return right + down;
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] paths = new int[m][n];
        return uniquePathsRecursive(m - 1, n - 1, paths);
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        int ret = obj.uniquePaths(7, 3);
        System.out.println(ret);
    }
}
