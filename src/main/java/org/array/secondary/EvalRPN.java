package org.array.secondary;

import javax.script.ScriptEngineManager;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/9 上午12:25
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Integer.valueOf(token));
            } else {
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                stack.push(getTempNum(p1, p2, token));
            }
        }
        return stack.pop();
    }

    public int getTempNum(int p1, int p2, String operator) {
        switch (operator) {
            case "+":
                return p2 + p1;
            case "-":
                return p2 - p1;
            case "*":
                return p2 * p1;
            case "/":
                return p2 / p1;
        }
        return 0;

    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
