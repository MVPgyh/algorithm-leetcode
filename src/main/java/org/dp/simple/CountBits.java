package org.dp.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/4 下午10:59
 */
public class CountBits {
    /*动态规划*/
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


    /*Brian Kernighan算法 */
    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            /*把x的比特位最右端的1变为0的结果*/
            x &= (x - 1);
            ones++;
        }
        return ones;
    }



    public static void main(String[] args) {
        System.out.println(countBits(20));
    }
}
