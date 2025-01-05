package org.recursion;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午1:28
 */
/*用递归 或 （2的幂次方的二进制位只有一个1）*/
public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        } else if (n % 2 == 1) {
            return false;
        }else {
            return isPowerOfTwo(n/2);
        }
    }

    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(6);
        System.out.println(powerOfTwo);
    }
}
