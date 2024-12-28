package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author pudding
 * @Date 2023/11/23 14:26
 */
public class MergeNC33 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        // list1 list2为空的情况
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1 == null && list2 == null) {
            return null;
        }
        //将两个两个链表存放在list中
        ArrayList<Integer> list = new ArrayList<>();
        // 遍历存储list1
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        // 遍历存储list2
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        // 对 list 排序
        Collections.sort(list);
        // 将list转换为 链表
        ListNode newHead = new ListNode(list.get(0));
        ListNode cur = newHead;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        // 输出合并链表
        return newHead;
    }

    public static void main(String[] args) {

    }
}
