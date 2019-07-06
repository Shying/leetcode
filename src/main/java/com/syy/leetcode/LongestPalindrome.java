package com.syy.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int center = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for(; center < s.length(); center++){
            int left = center;
            int right = center;
            int rightEven = center + 1;
            boolean oddEq = true;
            boolean evenEq = true;
//            以center为中间元素
            while (left >= 0 && right < s.length()){
                boolean hasEq = false;
                if (oddEq && s.charAt(left) == s.charAt(right)){
                    if (right - left > maxRight - maxLeft){
                        maxRight = right;
                        maxLeft = left;
                    }
                    hasEq = true;
                }else {
                    oddEq = false;
                }
                if (evenEq && rightEven < s.length() && s.charAt(left) == s.charAt(rightEven)){
                    if (rightEven - left > maxRight - maxLeft){
                        maxRight = rightEven;
                        maxLeft = left;
                    }
                    hasEq = true;
                }else {
                    evenEq = false;
                }
                if (!hasEq){
                    break;
                }

                left--;
                right++;
                rightEven++;
            }
            if(maxRight - maxLeft + 1 >= s.length()){
                break;
            }
        }
        if (maxRight < s.length()){
            return s.substring(maxLeft, maxRight + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        String ret = obj.longestPalindrome("caba");
        System.out.println(ret);
    }
}
