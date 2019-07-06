package com.syy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SingleNumber {
	public int singleNumber(int[] nums) {
		int value = 0;
		for (int i = 0; i < nums.length; i++) {
			value ^= nums[i];
		}
		return value;
    }

	public int singleNumberMap(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}else if (len == 1) {
			return nums[0];
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])){
				map.remove(nums[i]);
			}else {
				map.put(nums[i], 1);
			}
		}
		return map.keySet().iterator().next();
	}



    public static void main(String[] args) {
    	SingleNumber obj = new SingleNumber();
    	int ret = obj.singleNumber(new int[] {2, 2, 1});
    	System.out.println(ret);
    }
}