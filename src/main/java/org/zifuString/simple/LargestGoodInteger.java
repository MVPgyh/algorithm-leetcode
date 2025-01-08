package org.zifuString.simple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/8 下午9:07
 */
public class LargestGoodInteger {
    /*双指针写法*/
    public String largestGoodInteger(String num) {
        int len=num.length(),left=0,right=0;
        char[] arr = num.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        while (left <= right&&right!=len-1) {
            char l = arr[left];
            char r = arr[right];
            if (r == l) {
                right++;
            }else {
                left=right;
            }
            if (right - left + 1 == 3&&arr[right]==arr[left]) {
                list.add(arr[right]-'0');
            }
        }
        list.sort((o1, o2) -> o2-o1);
        if (!list.isEmpty()) {
            String s = list.get(0).toString();
            return s+s+s;
        }

        return "";
    }

    /*从9遍历*/
    public String largestGoodInteger1(String num) {
        /*for (char d = '9'; d >= '0'; d--) {
            String s = String.valueOf(d).repeat(3);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";*/
        return "";

    }

    public static void main(String[] args) {
        LargestGoodInteger lgi = new LargestGoodInteger();
        System.out.println(lgi.largestGoodInteger("2300019"));
    }
}
