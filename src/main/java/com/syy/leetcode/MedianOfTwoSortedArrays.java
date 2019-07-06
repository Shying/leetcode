package com.syy.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public double findMaxNSortedArrays(int[] nums1, int[] nums2, int N) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;

        if(num1Len + num2Len < N + 1){
            System.out.println("too large N");
            return 0;
        }else if (num1Len == 0 || num2Len == 0){
            int[] nums = num1Len == 0 ? nums2: nums1;
            return nums[N];
        }else if(num1Len + num2Len == N + 1) {
            return Math.max(nums1[num1Len - 1], nums2[num2Len - 1]);
        }else {
            double nums1Mid = nums1[num1Len / 2];
            double nums2Mid = nums2[num2Len / 2];
            int newN = 0;
            int[] bigNums = null;
            int[] smallNums = null;
            int bigLen = 0;
            int smallLen = 0;
            if(nums1Mid >= nums2Mid){
                bigNums = nums1;
                smallNums = nums2;
                bigLen = num1Len;
                smallLen = num2Len;
            }else{
                bigNums = nums2;
                smallNums = nums1;
                bigLen = num2Len;
                smallLen = num1Len;
            }

            int halfLen = smallLen / 2 + bigLen / 2 + 2;
            if(halfLen > N + 1){
                bigNums = Arrays.copyOfRange(bigNums, 0, bigLen / 2);
                newN = N;
            }else if(halfLen < N + 1){
                smallNums = Arrays.copyOfRange(smallNums, smallLen / 2 + 1, smallLen);
                newN = N - (smallLen - smallNums.length);
            } else{
                bigNums = Arrays.copyOfRange(bigNums, 0, bigLen / 2 + 1);
                smallNums = Arrays.copyOfRange(smallNums, smallLen / 2 + 1, smallLen);
                newN = N - (smallLen - smallNums.length);
            }

            return this.findMaxNSortedArrays(bigNums, smallNums, newN);
        }
    }

    public double findMedianSortedArraysSelf(int[] nums1, int[] nums2) {
        if((nums1.length + nums2.length) % 2 == 0){
            double num1 = this.findMaxNSortedArrays(nums1, nums2, (nums1.length + nums2.length) / 2);
            double num2 = this.findMaxNSortedArrays(nums1, nums2, (nums1.length + nums2.length) / 2 - 1);
            return (num1 + num2) / 2.0;
        }else{
            return this.findMaxNSortedArrays(nums1, nums2, (nums1.length + nums2.length) / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallNums = nums1;
        int[] bigNums = nums2;

        if(nums1.length > nums2.length){
            bigNums = nums1;
            smallNums = nums2;
        }
        int totalLen = smallNums.length + bigNums.length;
        if(totalLen == 0){
            return 0.0;
        }else if(totalLen == 1){
            return bigNums[0];
        }

        int halfLen = (totalLen + 1) / 2;

        int minPos = 0;
        int maxPos = smallNums.length;
        while(minPos <= maxPos){
            int i = (minPos + maxPos) / 2;
            int j = halfLen - i;
            if(i < maxPos && smallNums[i] < bigNums[j - 1]){
                minPos = i + 1;
            }else if(i > minPos && smallNums[i - 1] > bigNums[j]){
                maxPos = i - 1;
            }else{
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = bigNums[j - 1];
                }else if(j == 0){
                    maxLeft = smallNums[i - 1];
                }else {
                    maxLeft = Math.max(smallNums[i - 1], bigNums[j - 1]);
                }
                if(totalLen % 2 == 1){
                    return maxLeft;
                }
                int maxRight = 0;
                if(i == smallNums.length){
                    maxRight = bigNums[j];
                }else if(j == bigNums.length){
                    maxRight = smallNums[i];
                }else {
                    maxRight = Math.min(smallNums[i], bigNums[j]);
                }

                return (maxLeft + maxRight) / 2.0;
            }

        }
        return 0.0;

    }



    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
//        nums1 = [1, 3]
        //nums2 = [2]
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        double ret = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}
