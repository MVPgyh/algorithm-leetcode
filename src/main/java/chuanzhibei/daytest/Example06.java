package chuanzhibei.daytest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

/**
 * @Author pudding
 * @Date 2023/11/20 21:44
 */
public class Example06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] stus = new int[n];
        int[] record = new int[n];
        Arrays.fill(record, 1);
        for (int i = 0; i < n; i++) {
            stus[i] = scan.nextInt();
        }
        //正序遍历
        for (int i = 1; i < n; i++) {
            if (stus[i]>stus[i-1]) record[i]=(record[i-1]+1);
            if (stus[i]==stus[i-1]) record[i]=record[i-1];
        }

        //反序遍历
        for (int i = n-2; i >=0 ; i--) {
            if (stus[i]>stus[i+1]) record[i]=Math.max(record[i],record[i+1]+1);
            if (stus[i]==stus[i+1]) record[i]=Math.max(record[i],record[i+1]);
        }
        long ans = 0;
        for(int i = 0; i < n; i++) ans += record[i];
        System.out.println(ans);

/*//        System.out.println(Arrays.stream(record).sum());
        System.out.println(Arrays.stream(record).reduce(0, Integer::sum));*/


    }

}
