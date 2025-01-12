package thoughts.listnode;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 上午11:15
 */
/*虚拟头节点  不用虚拟头节点  递归*/
public class RemoveElements {
    /*官方递归写法*/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 方法1
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param val
     * @return
     */
    /*程序员卡尔 不设置虚拟头节点方法*/
    public ListNode removeElements1(ListNode head, int val) {
        /*寻找第一个不等于val的节点*/
        while (head != null && head.val == val) {
            head = head.next;
        }
        /*当前节点为第一个不等于val的节点*/
        ListNode curr = head;
        /*当前节点不为null 并且 next不为null*/
        while (curr != null && curr.next != null) {
            /*如果cur的next的值为val 则把当前节点下一个节点指向下下个节点*/
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                /*否则cur等于下一个节点*/
            } else {
                curr = curr.next;
            }
        }
        /*返回head即可*/
        return head;
    }

    /*设置虚拟头节点方法*/
    public ListNode removeElements2(ListNode head, int val){
        ListNode dummyNode = new ListNode();
        dummyNode.next=head;
        ListNode cur=dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return dummyNode.next;
    }
}
