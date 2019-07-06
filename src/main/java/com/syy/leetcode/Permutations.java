package com.syy.leetcode;

import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
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
