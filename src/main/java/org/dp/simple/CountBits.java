package org.dp.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/4 下午10:59
 */
public class CountBits {
    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(countBits(20));
    }
}
