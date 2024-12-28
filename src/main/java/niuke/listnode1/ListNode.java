package niuke.listnode1;

/**
 * @Author pudding
 * @Date 2023/11/23 12:35
 */
public class ListNode {
    public int val;
    public ListNode next ;


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public ListNode(int val) {
        this.val = val;
    }

}
