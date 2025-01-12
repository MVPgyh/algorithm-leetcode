package thoughts.listnode;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午7:53
 */
public class SwapPairs {
    /*迭代  定义虚拟头节点*/
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /*递归 TODO 很妙*/
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
