package niuke.listnode1.simple1;

import niuke.listnode1.ListNode;

import java.util.ArrayList;

/**
 * @Author pudding
 * @Date 2023/11/23 15:02
 */
public class FindKthToTailNC69 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ArrayList<ListNode> res = new ArrayList<>();
        // write code here
        while (pHead != null) {
            res.add(pHead);
            pHead=pHead.next;
        }
        if (res.size() < k||k==0) return  null;
        return res.get(res.size() - k);
    }


    public static void main(String[] args) {

    }
}
