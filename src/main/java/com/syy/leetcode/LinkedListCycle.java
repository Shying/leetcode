package com.syy.leetcode;

import java.util.*;

/**
 * 思路1：遍历，用map存储已遍历过的节点
 * 思路2：
 *
 *
 */
class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        int i = 0;
        while (head != null) {
        	if (map.containsKey(head)) {
        		return true;
        	} else {
        		map.put(head, i);
        	}

        	head = head.next;
        	i++;
        }
        return false;
    }

	public ListNode detectCycle(ListNode head) {
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		int i = 0;
		while (head != null) {
			if (map.containsKey(head)) {
				return head;
			} else {
				map.put(head, i);
			}

			head = head.next;
			i++;
		}
		return null;
	}

    public static void main(String[] args) {
    	LinkedListCycle obj = new LinkedListCycle();
    	ListNode node = ListNode.makeListNode("320");
    	node.nodeAt(node.size() - 1).next = node.nodeAt(1);
    	boolean ret = obj.hasCycle(node);
    	System.out.println(ret);
    }
}