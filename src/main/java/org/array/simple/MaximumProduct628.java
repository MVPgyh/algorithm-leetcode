package org.array.simple;

import java.util.Arrays;

public class MaximumProduct628 {
    //烂代码
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int zmax = nums[len - 1] * nums[len - 2] * nums[len - 3];
        if (nums[0] >= 0) return zmax;
        if (nums[len - 1] < 0) return zmax;
        if (nums[2] >= 0) {
            return nums[0] * nums[1] * nums[len - 1];
        } else {
            return Math.max(nums[0] * nums[1] * nums[len - 1], zmax);
        }
    }

    //数学算法排序
    public static int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    //线性扫描法  找出最大的三个数 和最小的两个数即可
    public static int maximumProduct2(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);


    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1, -2, -3}));
        System.out.println(maximumProduct1(new int[]{-1, -2, -3}));
    }
}
