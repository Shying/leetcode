package com.syy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseInteger {

    public boolean compareCharArray(char[] nums1, char[] nums2){
        if (nums1.length > nums2.length){
            return true;
        }else if (nums1.length == nums2.length){
            for (int i = 0; i < nums1.length; i++){
                if(nums1[i] > nums2[i]) {
                    return true;
                }else if(nums1[i] < nums2[i]){
                    return false;
                }
            }
        }
        return false;
    }

    public int reverse(int x) {
        if (x > -10 && x < 10){
            return x;
        }
        String strX = String.valueOf(x);
        boolean neg = strX.charAt(0) == '-';
        if(neg){
            strX = strX.substring(1);
        }
        char[] normal = strX.toCharArray();
        char[] reversed = new char[normal.length];
        int count = normal.length - 1;
        for (int i = 0; i < normal.length; i++) {
            reversed[i] = normal[count - i];
        }
        int i = 0;
        for(; i < reversed.length; i++){
            if(reversed[i] != 0){
                break;
            }
        }
        reversed = Arrays.copyOfRange(reversed, i, reversed.length);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(String.valueOf(reversed));
        if(!neg && this.compareCharArray(reversed, String.valueOf(Integer.MAX_VALUE).toCharArray())){
            return 0;
        }
        if(neg && this.compareCharArray(reversed, String.valueOf(Integer.MIN_VALUE).substring(1).toCharArray())){
            return 0;
        }
        int ret = Integer.valueOf(String.valueOf(reversed));
        return neg ? -ret : ret;
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int ret = obj.reverse(-2147483412);
        System.out.println(ret);
    }
}
