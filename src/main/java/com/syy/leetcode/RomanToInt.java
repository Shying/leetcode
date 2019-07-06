package com.syy.leetcode;
import java.util.*;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> avaliable = new HashMap<String, Integer>();
        avaliable.put("I", 1);
        avaliable.put("V", 5);
        avaliable.put("X", 10);
        avaliable.put("L", 50);
        avaliable.put("C", 100);
        avaliable.put("D", 500);
        avaliable.put("M", 1000);
        avaliable.put("IV", 4);
        avaliable.put("IX", 9);
        avaliable.put("XL", 40);
        avaliable.put("XC", 90);
        avaliable.put("CD", 400);
        avaliable.put("CM", 900);
        int i = 0;
        int sum = 0;
        while(i < s.length()){
            int j = i;
            while(j < s.length() && s.charAt(j) == s.charAt(i)){
                j++;
            }
            int count = j - i;
            int found = 0;
            if(j < s.length() && j >= 1 && s.charAt(j) != s.charAt(i)){
                String combine = s.substring(j - 1, j + 1);
                if(avaliable.containsKey(combine)){
                    found = avaliable.get(combine);
                    count--;
                    j++;
                }
            }
            if(count > 0){
                sum += avaliable.get(String.valueOf(s.charAt(i))) * count;
            }
            if(found > 0){
                sum += found;
            }
            i = j;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInt obj = new RomanToInt();
        System.out.println(obj.romanToInt("III"));
    }
}
