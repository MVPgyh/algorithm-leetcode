package org.numbers.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午2:51
 */
public class HammingWeight {
    public static void main(String[] args) {
        int i = hammingWeight1(21);

    }

    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int len=binaryString.length();
        int sum=0;
        for (int i = 0; i < len; i++) {
            if (binaryString.charAt(i) == '1') {
                sum+=1;
            }
        }
        return sum;
    }

    /*官方题解*/
    public static int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight2(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

}
