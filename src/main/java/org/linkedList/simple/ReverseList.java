package org.linkedList.simple;

import org.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午5:01
 */
public class ReverseList {
    /*双指针写法*/
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while (curr != null) {
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }

    /*递归写法*/
    public  static ListNode reverseList1(ListNode head) {
        return reverse(null,head);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode reverse = reverse(cur,cur.next);
        cur.next=pre;
        return reverse;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next=new ListNode(20);
        reverseList1(listNode);
    }

}
