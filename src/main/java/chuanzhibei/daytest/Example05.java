package chuanzhibei.daytest;

import java.util.Scanner;

/**
 * @Author pudding
 * @Date 2023/11/20 21:23
 */
public class Example05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a= sc.nextLong(),b= sc.nextLong();
        long absa=Math.abs(a);
        System.out.println(a = b < 0 ? -absa : absa);
    }
}
