package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author pudding
 * @Date 2023/11/23 15:19
 */
//反转链表用双链表实现 或者 递归 或者 双指针
public class ReverseListNC78 {
    public static ListNode ReverseList(ListNode head) {
        // write code here
        //遍历链表  添加到栈中
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
//        栈为空 返回null
        if (stack.isEmpty()) return head;
//        node代表最后入栈的一个节点 也就是结果的第一个节点 弹出的节点
        ListNode node = stack.pop();
//        dummy代表最后的返回结果 已经有第一个节点了
        ListNode dummy = node;
//        遍历栈中内容
        while (!stack.isEmpty()) {

            ListNode tempNode = stack.pop();
//          往 node添加节点
            node.next = tempNode;
//            节点下一位
            node=node.next;
        }
//       把结果的最后一个节点的下一个节点为null 否则会构成环  引起栈溢出异常

        node.next=null;
        return  dummy;


    }


//   双指针
    public static ListNode ReverseList1 (ListNode head) {
        ListNode newhead=null;
        while (head != null) {
            ListNode temp=head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
        l1.next = l2;
//        l2.next = l3;
        System.out.println(ReverseList1(l1));

    }
}
