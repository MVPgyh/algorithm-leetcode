package org.numbers.middle;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午7:45
 */
/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。*/
public class IntNumReverse {
    public static void main(String[] args) {
        int i = intNumReverse1(746384741);
        System.out.println(i);
    }

    public static int intNumReverse (int x) {
        int flag= x<0?1:0;
        StringBuilder buffer = new StringBuilder().append(Math.abs(x)).reverse();
        String s;
        if (flag == 1) {
           s=("-"+ buffer);
           return Integer.parseInt(s);
        }else {
            return Integer.parseInt(buffer.toString());
        }


    }

    public static int intNumReverse1 (int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
