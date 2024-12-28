package niuke.listnode1.middle;

import niuke.listnode1.ListNode;

/**
 * @Author pudding
 * @Date 2023/11/23 17:18
 */
public class AddInListNC40 {
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        // 进行判空处理
        if (head1 == null)
            return head2;
        if (head2 == null) {
            return head1;
        }
        // 反转h1链表
        head1 = reverse(head1);
        // 反转h2链表
        head2 = reverse(head2);
        // 创建新的链表头节点
        ListNode head = new ListNode(-1);
        ListNode nHead = head;
        // 记录进位的数值
        int tmp = 0;
        while (head1 != null || head2 != null) {
            // val用来累加此时的数值（加数+加数+上一位的进位=当前总的数值）
            int val = tmp;
            // 当节点不为空的时候，则需要加上当前节点的值
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            // 当节点不为空的时候，则需要加上当前节点的值
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            // 求出进位
            tmp = val / 10;
            // 进位后剩下的数值即为当前节点的数值
            nHead.next = new ListNode(val % 10);
            // 下一个节点
            nHead = nHead.next;

        }
        // 最后当两条链表都加完的时候，进位不为0的时候，则需要再加上这个进位
        if (tmp > 0) {
            nHead.next = new ListNode(tmp);
        }
        // 重新反转回来返回
        return reverse(head.next);


    }

    //    双链表 反转链表
    private ListNode reverse(ListNode head1) {
//        设置一个新的链表
        ListNode newhead = null;
//        遍历原链表
        while (head1 != null) {
//            设置一个临时节点为原链表得下一个节点
            ListNode temp = head1.next;
//            把原链表下一个节点 赋值为 新链表  即新链表挂载到原链表的后面
            head1.next = newhead;
//            新链表等于原来的链表
            newhead = head1;
//            循环条件变更 指针指向原链表的下一个节点
            head1 = temp;
        }
        return newhead;
    }

    public static void main(String[] args) {

    }
}
