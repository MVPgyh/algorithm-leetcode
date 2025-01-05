package org.zifuString.simple;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午9:22
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        /*map用作括号的映射*/
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        /*创建一个栈 可以用stack类 也可以用deque +linkedlist  推荐使用后者*/
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("(({))[]{}}"));
    }
}
