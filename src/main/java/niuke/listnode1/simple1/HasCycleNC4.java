package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author pudding
 * @Date 2023/11/23 12:42
 */
public class HasCycleNC4 {
    /**
     * 遍历链表中的每个节点 将他记录下来 一旦遇到了此前遍历过的节点 就可以判断存在环
     * 借助hash表可以实现
     * 第一步  while遍历链表  并将访问过的放在哈希表中
     * 第二步   判断节点是否在哈希表中 存在返回true
     * 遍历结束 返回false
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        while (head != null) {
            ListNode next = head.next;
            if (listNodes.contains(next)) {
                return  true;
            }else {
               listNodes.add(next);
            }
            head=head.next;
        }
        return false;
    }

//    双指针 快慢指针
    public boolean hasCycle1(ListNode head){
        if (head==null) return false;
        ListNode fast=head;
        ListNode slow=head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
            if (fast == slow) {
                return  true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(10);
        listNode1.next=listNode;

        HashSet<ListNode> listNodes = new HashSet<>();
        listNodes.add(listNode);
        listNodes.add(listNode1);
        System.out.println(listNodes.contains(listNode1));

    }
}
