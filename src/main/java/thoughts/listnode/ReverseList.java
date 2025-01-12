package thoughts.listnode;

import org.linkedList.ListNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午7:35
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
}
