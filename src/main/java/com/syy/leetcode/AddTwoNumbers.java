package com.syy.leetcode;

import java.util.*;


public class AddTwoNumbers {

    public ListNode nodeMultiply(ListNode node, int multi){
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int over = 0;
        while(node != null){
            int value = node.val * multi + over;
            cur.next = new ListNode(value % 10);
            over = value / 10;
            node = node.next;
            cur = cur.next;
        }
        if(over > 0){
            cur.next = new ListNode(over);
        }
        if(result.next != null){
            return result.next;
        }
        return null;
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        ListNode result = new ListNode(0);
        ListNode l1 = AddTwoNumbers.makeListNode(num1);
//        List<ListNode> multis = new ArrayList<ListNode>();
        int pos = -1;
        for(int i = num2.length() - 1; i >= 0; i--){
            pos++;

            int count = (int)num2.charAt(i) - (int)'0';
            if(count == 0){
                continue;
            }
            ListNode node = this.nodeMultiply(l1, count);
            if(node == null){
                continue;
            }
            if(node.val == 0 && node.next == null){
                continue;
            }
            for(int j = 0; j < pos; j++){
                ListNode head = new ListNode(0);
                head.next = node;
                node = head;
            }
//            multis.add(node);
            result = this.addTwoNumbers(result, node);

        }

        return this.getString(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode cur = sum;
        int over = 0;
        while(l1 != null && l2 != null){
            int value = l1.val + l2.val + over;
            over = value / 10;
            cur.next = new ListNode(value % 10);

            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        ListNode l = l1 == null ? l2: l1;
        while(l != null){
            int value = l.val + over;
            over = value / 10;
            cur.next = new ListNode(value % 10);

            l = l.next;
            cur = cur.next;
        }
        if(over > 0){
            cur.next = new ListNode(over);
        }
        if(sum.next != null){
            return sum.next;
        }
        return sum;
    }



    public int getInt(ListNode node){
        return Integer.valueOf(this.getString(node));
    }

    public String getString(ListNode node){
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val);
            node = node.next;
        }
        return sb.reverse().toString();
    }

    public static void mainAddTwoNumbers(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        String n1 = "5";
        String n2 = "5";
        ListNode l1 = AddTwoNumbers.makeListNode(n1);
        ListNode l2 = AddTwoNumbers.makeListNode(n2);
        ListNode result = obj.addTwoNumbers(l1, l2);
        System.out.println(obj.getInt(result) == (Integer.valueOf(n1) + Integer.valueOf(n2)));
        System.out.println(obj.getInt(result));
    }

    public static ListNode makeListNode(String strNum){
        ListNode head = new ListNode((int)strNum.charAt(strNum.length() - 1) - (int)'0');
        ListNode cur = head;
        if(strNum.length() < 2){
            return head;
        }
        for(int i = strNum.length() - 2; i >= 0; i--){
            cur.next = new ListNode((int)strNum.charAt(i) - (int)'0');
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        String n1 = "0";
        String n2 = "52";
//        ListNode l1 = obj.makeListNode(n1);
//        ListNode node = obj.nodeMultiply(l1, 5);
//        System.out.println(obj.getInt(node));

        String result = obj.multiply(n1, n2);
        System.out.println(result);
        System.out.println(Integer.valueOf(n1) * Integer.valueOf(n2));
    }


}
