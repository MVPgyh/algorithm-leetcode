package org.example;

/**
 * 颠倒二进制位
 * 32位无符号整数的二进制位
 */
public class ReverseBits {
    public static int rverseBits(int n) {
        int reverse = Integer.reverse(n);
        return reverse;

    }
    public static int rverseBits1(int n) {
        //用于记录反转后的值
        int rev=0;
        //循环最低位的比特 条件大于0 并且每一个比特循环一次
        for (int i = 0; i < 31 && n > 0; i++) {
            //首先数字n与1进行与运算，也就是最后一个比特进行位运算，是0与1进行与运算后是0
            //是1进行与运算后是1  总结出一个数与一进行与运算是其本身，与0进行或运算还是本身
            //将最后一个字符向左移相应的位数  第一个移位31 第二个移位30 依次类减
            //与rev进行或运算  因为int是32位，直接舍弃
            rev |=(n&1)<<(31-i);
            n>>>=1;
        }
        return  rev;
    }

    public static void main(String[] args) {
        System.out.println(rverseBits(0x0327));

    }
}
