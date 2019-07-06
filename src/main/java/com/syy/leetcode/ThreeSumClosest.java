package com.syy.leetcode;
import java.util.Arrays;
import java.lang.Integer;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            int sum = 0;
            for (int n: nums) {
                sum += n;
            }
            return sum;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
        	int twoTarget = target - nums[i];
        	int j = i + 1;
        	int k = nums.length - 1;
        	int lastSum = nums[j] + nums[k];
        	boolean moveJ = true;
        	while (j < k) {
        		int diff = twoTarget - (nums[j] + nums[k]);
        		if (Math.abs(diff) > Math.abs(twoTarget - lastSum)) {
        			if (moveJ){
        			    k--;
                        moveJ = false;
                    }else {
        			    j++;
                        moveJ = true;
                    }
        			continue;
        		}
                lastSum = nums[j] + nums[k];
        		if (diff < 0) {
        			k--;
                    moveJ = false;
        		} else if (diff > 0) {
        			j++;
                    moveJ = true;
        		} else {
        			return lastSum + nums[i];
        		}
        	}
        	if (Math.abs(target - (nums[i] + lastSum)) < Math.abs(target - closest)) {
        		closest = nums[i] + lastSum;
        	}
        }
        return closest;
    }

    public static void main(String[] args) {
    	ThreeSumClosest obj = new ThreeSumClosest();
    	int ret = obj.threeSumClosest(new int[] {1,2,5,10,11}, 12);
    	System.out.println(ret);
    }
}
