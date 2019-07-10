package com.syy.leetcode;

public class PowOfTwo {
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 2) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }

        return true;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        PowOfTwo obj = new PowOfTwo();
        boolean ret = obj.isPowerOfTwo(20);
        System.out.println(ret);
    }
}
