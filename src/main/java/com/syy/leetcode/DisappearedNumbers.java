package com.syy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        int len = nums.length;
        if (len == 0) {
            return ret;
        }

        for (int i = 0; i < len; i++) {
            int pos = i;
            int value = nums[pos];
            while (value != 0) {
//                System.out.print(pos + " " + value + " ");
//                printNums(nums);
                pos = value - 1;
                value = nums[pos];
                nums[pos] = 0;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DisappearedNumbers obj = new DisappearedNumbers();
        int[] array = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> ret = obj.findDisappearedNumbers(array);
        for(Integer i : ret) {
            System.out.print(i + " ");

        }
    }
}
