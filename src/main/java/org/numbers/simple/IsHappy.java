package org.numbers.simple;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午1:36
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int num) {
        HashSet<Integer> set = new HashSet<>();
        while (num != 1 && !set.contains(num)) {
            set.add(num);
            num=getPerSumNum(num);
        }
        return num==1;
    }

    public static int getPerSumNum(int n) {
        int sum=0;
        while (n != 0) {
            int digit=n%10;
            n=n/10;
            sum+=(digit*digit);
        }
        return sum;
    }
}
