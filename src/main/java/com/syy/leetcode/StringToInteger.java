package com.syy.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringToInteger {
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

    public String leftTrimStr(String str){
        int i = 0;
        for(; i < str.length(); i++){
            if(!(str.charAt(i) == ' ')){
                break;
            }
        }
        return str.substring(i);
    }
    public int myAtoi(String str) {
        str = this.leftTrimStr(str);
        if(str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        if(!((chars[0] <= '9' && chars[0] >= '0') || chars[0] == '+' || chars[0] == '-')){
            return 0;
        }

        StringBuilder builder = new StringBuilder();
        if(chars[0] == '-' || chars[0] == '+'){
            builder.append(chars[0]);
            chars = Arrays.copyOfRange(chars, 1, chars.length);
        }
        boolean hasNotZero = false;
        for(int i = 0; i < chars.length; i++){
            boolean legal = (chars[i] <= '9' && chars[i] >= '0');
            if(legal){
                if(!hasNotZero && chars[i] == '0'){
                    continue;
                }
                hasNotZero = true;
                builder.append(chars[i]);
            }else{
                break;
            }
        }
        if(builder.length() == 0){
            return 0;
        }
        boolean isNeg = false;
        char[] numbers = null;
        if(builder.charAt(0) == '-'){
            isNeg = true;
            numbers = builder.substring(1).toCharArray();
        }else if(builder.charAt(0) == '+'){
            numbers = builder.substring(1).toCharArray();
        }else{
            numbers = builder.toString().toCharArray();
        }
        if(numbers.length == 0){
            return 0;
        }
//        System.out.println(String.valueOf(Integer.MAX_VALUE));
//        System.out.println(String.valueOf(Integer.MIN_VALUE));
//        System.out.println(String.valueOf(numbers));
        if(!isNeg && this.compareCharArray(numbers, String.valueOf(Integer.MAX_VALUE).toCharArray())){
            return Integer.MAX_VALUE;
        }else if(isNeg && this.compareCharArray(numbers, String.valueOf(Integer.MIN_VALUE).substring(1).toCharArray())){
            return Integer.MIN_VALUE;
        }
        String strVal = String.valueOf(numbers);
        if(isNeg){
            strVal = "-" + strVal;
        }
        return Integer.valueOf(strVal);
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        int ret = 0;

        ret = obj.myAtoi("0-1");
        System.out.println(ret);
    }
}
