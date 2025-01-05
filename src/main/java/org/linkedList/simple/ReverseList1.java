package org.linkedList.simple;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午3:33
 */
public class ReverseList1 {
    public static void main(String[] args) {

    }
    /*迭代*/
    public ListNode reverseList(ListNode head) {
        ListNode curr=head,pre=null;
        while (curr != null) {
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }

    //    链表递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null,head);
    }

    public ListNode reverse(ListNode pre, ListNode curr) {
        if (curr == null) return pre;
        ListNode reverse = reverse(curr, curr.next);
        curr.next=pre;
        return reverse;
    }


}
