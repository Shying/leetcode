package com.syy.leetcode;

import java.util.HashMap;
import java.util.Map;

class ArrayProduct {
    Map<String, Integer> product = new HashMap<String, Integer>();
    int[] nums = null;
    
    public int subProduct(int start, int end) {
        // System.out.println("sub " + start + " " + end);
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return nums[start];
        }
        
        String key = start + "-" + end;
        if (product.containsKey(key)) {
            return product.get(key);
        }
        
        int left = subProduct(start + 1, end);
        int value = nums[start] * left;
        product.put(key, value);
        // System.out.println(key + " " + value);
        return value;
    }
    
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        this.nums = nums;
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            int ret = 1;
            if (i > 0) {
                int left = subProduct(0, i - 1);
                ret *= left;
            }
            if (i < len - 1){
                int right = subProduct(i + 1, len - 1);
                ret *= right;
            }
            // printProduct();
            result[i] = ret;
        }
        return result;
    }
    
    public void printProduct() {
        for (Map.Entry<String, Integer> entry : product.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
}