package org.linkedList.simple;

import org.linkedList.ListNode;

import java.util.Objects;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午4:03
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(0);
        listNode.next=head;
        ListNode temp=listNode;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return listNode.next;
    }
}
