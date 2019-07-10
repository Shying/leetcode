package com.syy.leetcode;

class ReverseWordsInString {
	public String reverseWords(String s) {
        int i = 0;

        char[] chars = s.toCharArray();
        int len = chars.length;
        while (i < len) {
        	while (i < len && chars[i] == ' ') {
        		i++;
        	}
        	int j = i + 1;
        	while (j < len && chars[j] != ' ') {
        		j++;
        	}
        	if (i >= len || j > len) {
        		break;
			}
        	int end = j;
        	int stop = i + (j - i) / 2;
        	while (i < stop) {
        		char charI = chars[i];
        		chars[i] = chars[j - 1];
        		chars[j - 1] = charI;
        		i++;
        		j--;
			}
			i = end + 1;
        }
        return String.valueOf(chars);
    }

	public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		String ret = obj.reverseWords("Let's take LeetCode contest");
		System.out.println(ret);
	}
}