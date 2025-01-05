package org.linkedList.old;

import org.linkedList.ListNode;

import java.util.Collections;
import java.util.LinkedList;

public class ReverList206 {
    //自己写的笨方法
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        LinkedList<Integer> ll = new LinkedList<>();
        while (head != null) {
            int val = head.val;
            ll.add(val);
            head=head.next;
        }
        ListNode ans = new ListNode(0);
        ListNode ans1 =ans;
        Collections.reverse(ll);
        for (int i = 0; i < ll.size(); i++) {
            ListNode createListNode=null;
            if (i != ll.size() - 1) {
                createListNode = new ListNode();
            }
            Integer integer = ll.get(i);
            ans1.val=integer;
            ans1.next=createListNode;
            ans1=ans1.next;
        }
        return ans;
    }
    //迭代 双指针
    public static ListNode reverseList1(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        System.out.println(reverseList(l1));
    }
}
