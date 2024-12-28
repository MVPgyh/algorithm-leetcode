package org.array.simple;

import java.util.Arrays;
import java.util.Map;

public class FindlosestNumber {
    //找出最接近0的数字
    public static int findClosestNumber(int[] nums) {
        //数组中最接近0的数字
        int ans=Integer.MAX_VALUE;
        //遍历数组 找出最接近0的数赋值给ans 返回ans
        for (int num :
                nums) {
            //数字取绝对值
            int absnum = Math.abs(num);
            //判断数字的绝对值小于ans，小于赋值给ans
            //如果不小于，绝对值相等的话 并且 ans大于负数 也把大的赋值给ans
            if (absnum < Math.abs(ans)||(absnum==Math.abs(ans)&&ans>num)) {
                ans=num;
            }
        }
        return  ans;

    }

    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));

    }
}
