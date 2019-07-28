package com.syy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public int calFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calFactorial(n - 1);
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int count = calFactorial(len);
        int[][] premutations = new int[count][len];
        int index = 0;
        for (int i = 0; i < len; i++) {


        }
        return null;
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        List<List<Integer>> ret = obj.permute(new int[] {1, 2, 3});
        for(int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.get(i).size(); j++) {
                System.out.print(ret.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
