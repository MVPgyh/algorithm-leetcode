package thoughts.listnode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午2:08
 */
public class MyLinedList1 {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head;
    ListNode tail;

    public MyLinedList1() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        if (index < size/2) {
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        } else {
            ListNode cur = tail;
            for (int i = size; i > index; i--) {
                cur = cur.prev;
            }
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }


}

