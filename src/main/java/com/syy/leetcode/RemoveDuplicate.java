package com.syy.leetcode;

class RemoveDuplicate {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
        int last = nums[0];
        int newPos = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != last) {
        		nums[newPos] = nums[i];
        		last = nums[i];
        		newPos++;
        	}
        }
        return newPos;
    }

    public static void main(String[] args) {
    	RemoveDuplicate obj = new RemoveDuplicate();
    	int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
    	int ret = obj.removeDuplicates(nums);
    	System.out.println(ret);
    	for (int i = 0; i < nums.length; i++){
    		System.out.print(nums[i] + " ");
		}
    }
}