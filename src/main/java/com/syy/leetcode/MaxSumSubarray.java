package com.syy.leetcode;

import java.lang.Integer;

class MaxSumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {	
            int sum = curSum + nums[i];
        	if (nums[i] > sum) {
    			curSum = nums[i];
    		}else {
    			curSum = sum;
    		}
    		if(curSum > max) {
    			max = curSum;
    		}
        }
        return max;
    }

    public static void main(String[] args) {
    	MaxSumSubarray obj = new MaxSumSubarray();
    	int ret = obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    	System.out.println(ret);
    }
	
}