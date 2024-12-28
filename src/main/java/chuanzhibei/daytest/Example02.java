package chuanzhibei.daytest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author pudding
 * @Date 2023/11/20 19:48
 */
public class Example02 {

    private static int[] test01(int n) {
        int[] result = new int[2];
        double treeside=Math.pow(n,2);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == treeside) {
                    return new int[]{i,j};
                }
            }
        }
        return  result;
    }

    public  static  int[] test02(int n){
        HashMap<Double,Integer> hm = new HashMap<>();
        double treeside=Math.pow(n,2);
        for (int i = 1; i < n; i++) {
            double firstSide = Math.pow(i, 2);
            double  secondSide=treeside-firstSide;
            if (hm.containsKey(secondSide)) {
                return  new int[]{i, (hm.get(secondSide))};
            }
            hm.put(firstSide,i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(test01(10)));
        System.out.println(Arrays.toString(test02(13)));
    }
}
