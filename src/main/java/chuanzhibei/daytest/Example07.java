package chuanzhibei.daytest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author pudding
 * @Date 2023/11/21 11:11
 */
public class Example07 {
    public static int[] a = new int[200005];
    public static int[] b = new int[200005];
    public static int[] c = new int[200005];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        输入m和n n=5 m=4
        int n = scanner.nextInt(), m = scanner.nextInt();
//        取出m或者n的最大值
        int maxLength = Math.max(n, m);
//
        for (int i = (maxLength - n) + 1; i <= maxLength; ++i) {
            a[i] = scanner.nextInt();
        }
        for (int i = (maxLength - m) + 1; i <= maxLength; ++i) {
            b[i] = scanner.nextInt();
        }
        for (int i = maxLength, cnt = 2; i > 0; --i, ++cnt) {
            c[i] += a[i] + b[i];
            if (c[i] >= cnt) {
                c[i] -= cnt;
                c[i - 1] += 1;
            }
        }
        if (c[0] > 0) {
            System.out.printf("%d ", c[0]);
        }
        for (int i = 1; i <= maxLength; ++i) {
            System.out.printf("%d ", c[i]);
        }
        System.out.println();

    }


}
