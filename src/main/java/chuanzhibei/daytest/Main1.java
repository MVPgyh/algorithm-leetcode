package chuanzhibei.daytest;

import java.util.Scanner;
import java.lang.Math;

/**
 * @Author pudding
 * @Date 2023/11/20 19:14
 */
public class Main1 {
   static float test(int score){
        if (score >= 90) {
            return 4.0f;
        }
        if (score < 90 && score >= 60) {
            return (float) (score - 50) / 10;
        }else {
            float sqrt = (float) (Math.sqrt(score)*10);
            System.out.println(sqrt);
            if (sqrt < 60) {
                return (sqrt - 50) / 10;
            }
            return  (sqrt - 50) / 10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
