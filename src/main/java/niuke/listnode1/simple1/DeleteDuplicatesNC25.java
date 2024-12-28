package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.HashSet;

/**
 * @Author pudding
 * @Date 2023/11/23 13:38
 */
public class DeleteDuplicatesNC25 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
//        空链表情况
        if (head==null) return null;

//        循环链表每一个节点  如果这个节点和下个节点相同 则下一个节点为下下节点 跳过下一个节点
        ListNode cur=head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {


    }
}
