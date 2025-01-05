package org.linkedList.middle;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午5:12
 */
/*1.穿针引线 2.一次遍历 头插法*/
public class ReverseBetween {
    /*穿针引线*/
    public ListNode reverseBetween(ListNode head, int left, int right) {
//        因为头节点有可能发生变化 使用虚拟头节点 可以避免复杂的分类讨论 创建一个虚拟节点
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;


        /*从虚拟头节点走left-1步*/
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre=pre.next;
        }
        /*从pre走到right-left+1步骤，来到right节点*/
        ListNode rightNode=pre;
        for (int i = 0; i < right - left+1; i++) {
            rightNode=rightNode.next;
        }

//      切断出一个子链表 截取链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
//        切断链接
        pre.next=null;
        rightNode.next=null;

//        反转子区间
        reverseLinkedList(leftNode);
//        接回原来的链表中
        pre.next=rightNode;
        leftNode.next=curr;
        return dummyNode.next;

    }

    public void reverseLinkedList(ListNode head) {
//        迭代（双指针反转链表）
        ListNode pre=null,curr=head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
