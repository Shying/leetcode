package com.syy.leetcode;

import java.util.HashMap;
import java.util.*;

public class LongestSubstring {

    /**
     * 暴力算法，直接遍历
     *
     * @param s
     *
     * @return
     */
    public int lengthOfLongestSubstring_V1(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.length() - i < max) {
                break;
            }
            Map<String, Integer> charPos = new HashMap<String, Integer>();
            charPos.put(String.valueOf(s.charAt(i)), i);
            boolean repeat = false;
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (charPos.containsKey(String.valueOf(s.charAt(j)))) {
                    repeat = true;
                    break;
                }
                charPos.put(String.valueOf(s.charAt(j)), j);
            }

            int length = j - i;
            if (length > max) {
                max = length;
            }

        }
        return max;
    }

    /**
     * 1. 遍历s，将各个字符出现的pos存储下来
     * 2. 找其中pos最多的字符，分隔字符串后，递归调用
     *
     * @param s String
     *
     * @return int[]
     */
    public int[] longestSubstring(String s) {
        //        System.out.println(s);
        Map<String, List<Integer>> charPosList = new HashMap<String, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if (!charPosList.containsKey(key)) {
                charPosList.put(key, new ArrayList<Integer>());
            }
            charPosList.get(key).add(i);
        }
        //        System.out.println(charPosList);

        String maxPosKey = null;
        int maxPosLen = 0;
        for (Map.Entry<String, List<Integer>> item : charPosList.entrySet()) {
            if (item.getValue().size() > maxPosLen) {
                maxPosLen = item.getValue().size();
                maxPosKey = item.getKey();
            }
        }
        //        System.out.println(maxPosKey + " " + maxPosLen);

        List<Integer> maxPosList = charPosList.get(maxPosKey);
        if (maxPosList == null || maxPosList.size() < 2) {
            return new int[] {s.length(), 0, s.length() - 1};
        }

        maxPosList.add(0, -1);
        maxPosList.add(s.length());

        int[] childMax = new int[] {0, 0, 0};
        int childMaxLen = 0;
        for (int i = 1; i < maxPosList.size() - 1; i++) {
            String sub = s.substring(maxPosList.get(i - 1) + 1, maxPosList.get(i + 1));
            //            System.out.println(sub + " " + (maxPosList.get(i - 1) + 1) + " " + (maxPosList.get(i + 1)));
            int[] curLen = null;
            if (sub.length() < 2) {
                curLen = new int[] {sub.length(), 0, sub.length() - 1};
            } else {
                curLen = this.longestSubstring(sub);
            }

            if (curLen[0] > childMaxLen) {
                childMaxLen = curLen[0];
                childMax = curLen;
            }
        }
        return childMax;
    }

    public int lengthOfLongestSubstring(String s) {
//        int[] maxSubstring = this.longestSubstring(s);
//        return maxSubstring[0];
        return this.movingWindow(s);
    }

    public int movingWindow(String s) {
        if(s.length() < 2){
            return s.length();
        }
        int max = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            char value = s.charAt(i);
            int exist = s.indexOf(value, start);
            if(exist >= start && exist <= end){
                start = exist + 1;
            }
            end++;
            int curLen = end - start + 1;
            if(curLen > max){
                max = curLen;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring obj = new LongestSubstring();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
