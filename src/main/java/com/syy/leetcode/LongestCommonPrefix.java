package com.syy.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int pos = 0;
        StringBuilder builder = new StringBuilder();
        boolean over = false;
        while (true) {
            if (pos >= strs[0].length()){
                break;
            }
            char ch = strs[0].charAt(pos);
            boolean same = true;
            for (int i = 1; i < strs.length; i++){
                if (pos >= strs[i].length()){
                    over = true;
                    same = false;
                    break;
                }
                if(ch != strs[i].charAt(pos)){
                    same = false;
                    break;
                }
            }
            if (over){
                break;
            }
            if (same){
                builder.append(ch);
            }else{
                break;
            }
            pos++;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[] {"aca", "cba"}));
    }
}
