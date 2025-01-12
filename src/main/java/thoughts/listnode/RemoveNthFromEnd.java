package thoughts.listnode;

import org.linkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午8:45
 */
/*删除链表倒数第N个节点
 * 学会了提前定义一个虚拟头节点保证返回
 * 定义一个虚拟节点也不用想着边界值如何 即头节点被删除
 *
 * 三种解法 1.得出链表长度，遍历到指定地点跳过被删除的节点
 *         2.使用栈，弹出倒数n个元素后 在peek为pre
 *         3.使用快慢指针 TODO 移除倒数元素
 * */
public class RemoveNthFromEnd {
    /*暴力解法 找到被删除元素的前一个节点，把前一个节点的下一个节点指向下下节点*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        /*获取链表长度*/
        while (head != null) {
            len += 1;
            head = head.next;
        }
        ListNode curr = dummyNode;
        for (int i = 0; i < len - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummyNode.next;
    }

    /*栈*/
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        /*创建虚拟头节点*/
        ListNode dummyNode=new ListNode();
        dummyNode.next=head;
        ListNode cur=dummyNode;
        /*创建一个栈把链表放进去*/
        Deque<ListNode> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur);
            cur=cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        /*找出被删除元素的上一个节点*/
        ListNode pre = stack.peek();
        pre.next=pre.next.next;
        return dummyNode.next;

    }
    /*双指针*/
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
