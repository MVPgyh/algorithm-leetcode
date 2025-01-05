package org.recursion;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午1:23
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int fib1 = fib.fib(4);
        System.out.println(fib1);
    }
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
