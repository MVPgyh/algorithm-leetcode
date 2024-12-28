package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.LinkedList;

/**
 * @Author pudding
 * @Date 2023/11/23 16:36
 */
public class DeleteNodeNC289 {
    public ListNode deleteNode(ListNode head, int val) {
//        最后得去掉头节点
        ListNode res = new ListNode(0);
        res.next = head;

//        前序节点
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;


    }

    public ListNode deleteNode1(ListNode head, int val) {

        // 1、创建返回结果
        ListNode res = head;

        // 2、判断第一个是不是要删除的节点
        if (head.val == val) {
            // 第一是的话，跳过这个节点，并返回
            head = head.next;
            return head;
        }


        // 3、遍历，找到要删除的节点 head.next.val != val 时进入循环
        while (head.next.val != val) {
            // 不是目标值，跳过这个节点
            head = head.next;
        }

        // 4、找到目标值后跳出循环，跳出循环向下执行，说明链表当前值与val相等，执行链表删除操作。
        //  说明：因为在while循环中head指向了下一个节点，所以此时head表示为前一个节点，head.next表示为目标节点，head.next.next 表示下一个节点
        //       所以，将前一个节点的next直接连接到下一个节点，达到了删除节点的效果，
        head.next = head.next.next;

        return res;

    }

    public static void main(String[] args) {

    }
}
