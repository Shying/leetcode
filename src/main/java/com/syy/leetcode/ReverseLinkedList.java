package com.syy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ReverseLinkedList {
	public ListNode[] reverseListRecursive(ListNode head) {
        if (head.next != null) {
        	ListNode[] nodeList = reverseListRecursive(head.next);
			head.next = null;
			nodeList[1].next = head;
        	return new ListNode[] {nodeList[0], head};
        }else {
        	return new ListNode[] {head, head};
        }
    }

    public ListNode reverseList1(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode[] nodeList = reverseListRecursive(head);
		return nodeList[0];
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null) {
			return null;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		for (int i = list.size() - 1; i > 0; i--) {
			list.get(i).next = list.get(i - 1);
			list.get(i - 1).next = null;
		}
		return list.get(list.size() - 1);
	}

    public static void main(String[] args) {
    	ReverseLinkedList obj = new ReverseLinkedList();
    	ListNode node = ListNode.makeListNode("12345");
    	ListNode ret = obj.reverseList1(node);
    	System.out.println(ret.toString());
    }
}