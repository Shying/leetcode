package com.syy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RotateList {
    public ListNode rotateRightLink(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        k = k % len;
        for (int i = 0; i < k; i++) {
            if (cur.next != null)
                cur = cur.next;
            else
                cur = head;
        }
        if (cur == head) {
            return head;
        }
        ListNode newTail = cur;
        ListNode newHead;
        if (cur.next == null) {
            newHead = head.next;
            newTail = head;
        }else {
            newHead = cur.next;
        }
        ListNode newCur = newHead;
        while (newCur.next != null) {
            newCur = newCur.next;
        }
        newCur.next = head;
        newTail.next = null;
        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> array = new ArrayList<Integer>();
        ListNode oldHead = head;
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int len = array.size();
        if (len == 0) {
            return oldHead;
        }
        k = k % array.size();
        if (k == 0) {
            return oldHead;
        }
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        for (int i = (len - k); i < len; i++) {
            cur.next = new ListNode(array.get(i));
            cur = cur.next;
        }
        for (int i = 0; i < (len - k); i++) {
            cur.next = new ListNode(array.get(i));
            cur = cur.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode node = ListNode.makeListNode("012");
        ListNode ret = obj.rotateRight(node, 1);
        System.out.println(ret.toString());
    }
}