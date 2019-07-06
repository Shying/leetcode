package com.syy.leetcode;
import java.lang.StringBuilder;

class ValidParentheses {
	public boolean isValid(String s) {
		String leftParentheses = "[{(";
		String rightParentheses = "]})";
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (leftParentheses.indexOf(ch) >= 0) {
				stack.append(leftParentheses.indexOf(ch));
        	}else{
        		int lastPos = stack.length() - 1;
        		if (lastPos < 0) {
        			return false;
				}
        		int lastCh = stack.charAt(lastPos) - '0';
				stack.deleteCharAt(lastPos);
				if (rightParentheses.indexOf(ch) != lastCh){
					return false;
				}
        	}
        }
        if(stack.length() > 0) {
        	return false;
		}
        return true;
    }

    public static void main(String[] args) {
    	ValidParentheses obj = new ValidParentheses();
    	boolean ret = obj.isValid("{}{}{]");
    	System.out.println(ret);
    }
}