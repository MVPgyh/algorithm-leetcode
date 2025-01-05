package org.linkedList.simple;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午4:15
 */
public class IsPalindrome {
    /*1 2 2 1*/
    public static boolean isPalindrome(ListNode head) {
        ListNode origin=head;
        ListNode pre=null,curr=head;
        while (curr != null) {
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }

        while (pre != null) {
            if (origin.val != pre.val) {
                return false;
            }
            origin=origin.next;
            pre=pre.next;
        }
        return true;

    }

    public static void main(String[] args) {
    }
}
