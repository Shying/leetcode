package com.syy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            subs.add(new ArrayList<Integer>());
            return subs;
        }
        List<List<Integer>> childs = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        subs.addAll(childs);
        for (List<Integer> one: childs) {
            List<Integer> newOne = new ArrayList<Integer>(one);
            newOne.add(0, nums[0]);
            subs.add(newOne);
        }

        return subs;
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        List<List<Integer>> ret = obj.subsets(new int[]{1, 2, 3});
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> l = ret.get(i);
            int lSize = l.size();
            System.out.print("#" + i + "#");
            for (int j = 0; j < lSize; j++) {
                System.out.print(l.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
