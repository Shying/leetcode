package com.syy.leetcode;


public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        int current = m + n - 1;
        while(pos1 >= 0 && pos2 >= 0) {
            if (nums1[pos1] <= nums2[pos2]) {
                nums1[current] = nums2[pos2];
                pos2--;
            }else {
                nums1[current] = nums1[pos1];
                pos1--;
            }
            current--;
        }
        while (pos2 >= 0) {
            nums1[current] = nums2[pos2];
            pos2--;
            current--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
        int[] nums1 = new int[] {4,5,6,0,0,0};
        obj.merge(nums1, 3, new int[]{1,2,3}, 3);
        PrintUtil.printArray(nums1);
    }
}
