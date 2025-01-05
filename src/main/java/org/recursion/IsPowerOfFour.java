package org.recursion;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午2:34
 */
public class IsPowerOfFour {
    public static void main(String[] args) {

    }
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return n % 4 == 0 && isPowerOfFour(n / 4);
    }
}
