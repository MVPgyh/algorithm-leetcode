package org.numbers.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/31 上午12:06
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
    public static int mySqrt(int x) {

        for (int i = 0; ; i++) {
            int i1 = i * i;
            int i2 = (i + 1) * (i + 1);
            if (i1 == x || (i1 < x && i2 > x)) {
                return i;

            }
        }
    }
}
