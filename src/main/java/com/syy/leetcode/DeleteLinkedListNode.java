package com.syy.leetcode;


class DeleteLinkedListNode {

	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        if (node.next.next != null) {
        	node.next = node.next.next;
        }else {
        	node.next = null;
        }
    }


}