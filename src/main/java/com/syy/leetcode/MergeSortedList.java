package com.syy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}else if (l2 == null) {
			return l1;
		}
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null) {
        	if (p1.val <= p2.val) {
        		cur.next = p1;
        		p1 = p1.next;
        	}else {
        		cur.next = p2;
        		p2 = p2.next;
        	}
			cur = cur.next;
        }
        while (p1 != null) {
        	cur.next = p1;
        	p1 = p1.next;
        	cur = cur.next;
        }
        while (p2 != null) {
        	cur.next = p2;
        	p2 = p2.next;
			cur = cur.next;
        }
        return head.next;
    }

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		List<ListNode> pointers = new ArrayList<ListNode>(Arrays.asList(lists));
		List<Integer> toDel = new ArrayList<Integer>();
		while(pointers.size() > 0){
			ListNode min = null;
			int minPos = 0;
			toDel.clear();
			for (int i = 0; i < pointers.size(); i++) {
				if (pointers.get(i) == null) {
					toDel.add(i);
					continue;
				}
				if (min == null) {
					min = pointers.get(i);
					minPos = i;
					continue;
				}
				if (pointers.get(i).val < min.val) {
					min = pointers.get(i);
					minPos = i;
				}
			}
			if (min == null) {
				break;
			}


			cur.next = min;
			cur = cur.next;

			if (min.next == null) {
				toDel.add(minPos);
			}else {
				pointers.set(minPos, min.next);
			}

			for(int i = toDel.size() - 1; i >= 0; i--) {
				pointers.remove(toDel.get(i).intValue());
			}
		}
		if (head.next != null) {
			return head.next;
		}else {
			return null;
		}

	}

    public static void main(String[] args) {
    	MergeSortedList obj = new MergeSortedList();
    	ListNode l1 = ListNode.makeListNode("1123345");
    	System.out.println(l1);
    	ListNode l2 = ListNode.makeListNode("3344567");
		System.out.println(l2);
		ListNode l3 = ListNode.makeListNode("169");
		System.out.println(l3);
    	ListNode ret = obj.mergeKLists(new ListNode[] {l1, l2, l3});
    	System.out.println(ret);
    }
}