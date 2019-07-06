package com.syy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null;}

	public String toString(){
		String s = val + "";
		if (next != null) {
			s += "->";
			s += next.toString();
		}
		return s;
	}

	public static ListNode makeListNode(String strNum){
        ListNode head = new ListNode((int)strNum.charAt(0) - (int)'0');
        ListNode cur = head;
        if(strNum.length() < 2){
            return head;
        }
        for(int i = 1; i < strNum.length(); i++){
            cur.next = new ListNode((int)strNum.charAt(i) - (int)'0');
            cur = cur.next;
        }
        return head;
    }

    public ListNode nodeAt(int i) {
		int pos = 0;
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		ListNode head = this;
		while (head != null) {
			if (map.containsKey(head)) {
				break;
			}
			map.put(head, pos);
			if (pos == i) {
				return head;
			}
 			head = head.next;
			pos++;
		}
		return null;
	}

	public int size() {
		int i = 0;
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		ListNode head = this;
		while (head != null) {
			if (map.containsKey(head)) {
				break;
			}

			map.put(head, i);
			i++;
			head = head.next;
		}
		return i;
	}

}