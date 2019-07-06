package com.syy.leetcode;

public class ClimbingStairs {


    public int climbStairsSub(int n, int[] hasProcessed) {
        if (n <= 2) {
            return n;
        }
        if (hasProcessed[n] > 0) {
            return hasProcessed[n];
        }
        int remain1 = this.climbStairsSub(n - 1, hasProcessed);
        hasProcessed[n - 1] = remain1;
        int remain2 = this.climbStairsSub(n - 2, hasProcessed);
        hasProcessed[n - 2] = remain2;
        return remain1 + remain2;
    }

    public int climbStairs(int n) {
        int[] hasProcessed = new int[n + 1];
        return this.climbStairsSub(n, hasProcessed);
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        int ret = obj.climbStairs(1);
        System.out.println(ret);
    }
}
