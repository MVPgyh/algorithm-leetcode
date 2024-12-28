package org.linkedList;

public class MergeTwoLists21 {
    //循环加双指针法 最高效的
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode ln=new ListNode(0);
        ListNode p=ln;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next=list1;
                list1=list1.next;
            }
            else {
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }
        if (list1 != null) {
            p.next=list1;
        }
        if (list2 != null) {
            p.next=list2;
        }
        return ln.next;

    }
    //递归
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {

    }
}
