package chuanzhibei.daytest;

import java.util.Scanner;



/**
 * @Author pudding
 * @Date 2023/11/20 20:30
 */
public class Example04 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a,p;
        for (int i = 0; i < n; i++) {
            a=sc.nextInt();
            p=sc.nextInt();
            if(p<16) a-=10;
            if(p>=20) a-=p-20;
            if(a<=0)a=0;
            System.out.println(a);
        }
        System.out.println(Math.pow(10, 20));

    }
}
