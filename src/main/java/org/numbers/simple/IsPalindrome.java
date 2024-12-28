package org.numbers.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午10:31
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin=x;
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            res = res * 10 + digit;
        }
        return res==origin;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(10);
        System.out.println(palindrome);
    }
}
