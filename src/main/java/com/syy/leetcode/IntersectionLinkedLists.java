package com.syy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionLinkedLists obj = new IntersectionLinkedLists();
        ListNode a = ListNode.makeListNode("12345");
        ListNode b = ListNode.makeListNode("789");
        b.nodeAt(b.size() - 1).next = a.nodeAt(3);
        ListNode inter = obj.getIntersectionNode(a, b);
        System.out.println(inter.val);
    }
}
