package com.syy.leetcode;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int ret = obj.majorityElement(new int[] {2,2,1,1,1,2,2});
        System.out.println(ret);
    }
}
