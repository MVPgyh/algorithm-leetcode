package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.HashSet;

/**
 * @Author pudding
 * @Date 2023/11/23 14:49
 */
public class FindFirstCommonNodeNC66 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> hs = new HashSet<>();
        while (pHead1 != null) {
            hs.add(pHead1);
            pHead1=pHead1.next;
        }

        while (pHead2 != null) {
            if (hs.contains(pHead2)) {
                return  pHead2;
            }
            pHead2=pHead2.next;
        }
        return null;


    }

    public static void main(String[] args) {

    }
}


