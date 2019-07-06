package com.syy.leetcode;

import java.util.*;
import java.lang.*;

class MinStack {

	private List<ListNode> list;
	private ListNode min;
	private int size;

	public MinStack() {
        this.list = new ArrayList<ListNode>();
        this.min = null;
        this.size = 0;
    }
    
    public void push(int x) {
        ListNode node = new ListNode(x);
        if (this.min == null) {
            this.min = node;
        }else {
            if (x < this.min.val) {
                node.next = this.min;
                this.min = node;
            }
        }
        this.list.add(node);
        size++;
    }
    
    public void pop() {
	    if (size == 0) {
	        return;
        }
	    ListNode t = this.list.get(size - 1);
	    if (min == t) {
	        min = t.next;
        }
        this.list.remove(size - 1);
	    size--;
    }
    
    public int top() {
	    if (size == 0) {
	        return -1;
        }
        return this.list.get(size - 1).val;
    }
    
    public int getMin() {
	    if (this.min != null) {
            return this.min.val;
        }
        return -1;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int ret = minStack.getMin();   // --> 返回 -3.
		System.out.println(ret);
		minStack.pop();
		ret = minStack.top();      // --> 返回 0.
		System.out.println(ret);
		ret = minStack.getMin();   // --> 返回 -2.
		System.out.println(ret);
    }
}