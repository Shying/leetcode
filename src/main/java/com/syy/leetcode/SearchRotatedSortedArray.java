package com.syy.leetcode;

class SearchRotatedSortedArray {
	public int searchRecursive(int[] nums, int target, int pStart, int pEnd) {
		int numLen = pEnd - pStart + 1;
		if (numLen <= 0){
		    return -1;
        }else if (numLen == 1) {
			if (nums[pStart] == target) {
				return pStart;
			}
			return -1;
		}

        int halfLen = pStart + numLen / 2;
        int start = nums[pStart];
        int half = nums[halfLen];
        int end = nums[pEnd];

        if (target == start) {
        	return pStart;
        }else if (target == half) {
        	return halfLen;
        }else if (target == end) {
        	return pEnd;
        }

        if (start < half) {
        	if (start < target && target < half) {
        		return this.searchRecursive(nums, target, pStart + 1, halfLen - 1);
        	}else {
	        	return this.searchRecursive(nums, target, halfLen + 1, pEnd - 1);
        	}
        }else {
        	if (half < target && target < end) {
        		return this.searchRecursive(nums, target, halfLen + 1, pEnd - 1);
        	}else {
	        	return this.searchRecursive(nums, target, pStart + 1, halfLen - 1);
        	}
        }
    }

    public int search(int[] nums, int target) {
        return this.searchRecursive(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
    	SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
    	int ret = obj.search(new int[] {4, 5}, 5);
    	System.out.println(ret);
    }
    
}