package com.syy.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        int i = 0;
        int j = strX.length() - 1;
        while(i <= j){
            if(strX.charAt(i) == strX.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        System.out.println(obj.isPalindrome(10));
    }
}
