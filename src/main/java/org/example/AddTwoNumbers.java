package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers {
    /**链表对应数字位相加*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //list接口下的实现了类 双端队列 可以作为栈也可以作为队列
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        //学会了如果遍历链表 并且压入栈中 第一个链表压入栈中
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        //第二个链表值压入栈中
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        //定义变量carry是进位的大小
        int carry = 0;
        //返回值ans链表
        ListNode ans = null;
        //      依次取出栈顶的数字
        //判断栈是否为空，两个栈顶都不是空  栈1不是空 或者栈2不是空 或者carry不是0 进入循环
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            //取出栈1栈顶的数组，判断是否为空，空就为0，非空就取出
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            //同上一行代码
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            //cur 等于 a+b+carry
            int cur = a + b + carry;
            //获取十位数字
            carry = cur / 10;
            //获取各位数字
            cur %= 10;
            //创建返回的结果链表
            ListNode curnode = new ListNode(cur);
            //为链表节点复制
            //往头节点添加数字
            //先创建一个链表，让这个链表的下一个节点为ans 紧接着让ans等于创建的列表
            //俗称头插法
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }




    public static void main(String[] args) {

    }
}
