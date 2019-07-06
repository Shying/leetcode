package com.syy.leetcode;

public class ContainerWithMostWater {
    public int maxAreaNaive(int[] height) {
        int max = 0;
        int size = height.length - 1;
        for(int i = 0; i < size; i++){
            for(int j = size; j > i; j--){
                //            如果以左边为界，长取最长仍然小于max，直接退出
                if(height[i] * (j - i) < max){
                    break;
                }
                int area = (j - i) * Math.min(height[i], height[j]);
                if(area > max){
                    max = area;
                }
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int ret = obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(ret);
    }
}
