package chuanzhibei.daytest;

import java.util.Scanner;

/**
 * @Author pudding
 * @Date 2023/11/20 20:12
 */
public class Example03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble(),
                h = sc.nextDouble(),
                e = sc.nextDouble();
        System.out.print((int) (t * 0.2 + h * 0.3 + e * 0.5));
    }
}
