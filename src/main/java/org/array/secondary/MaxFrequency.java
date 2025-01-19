package org.array.secondary;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午2:32
 */
/*3346. 执行操作后元素的最高频率 I*/
public class MaxFrequency {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        /*遍历数组中每个数字并添加到map中，有的话则相加覆盖  merge方法*/
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        /*排序数组*/
        Arrays.sort(nums);
        int ans = 0;
        /*遍历该数组中*/
        for (int num : nums) {
            /*计算第一个不小于num-k的元素的索引 lr都是计算边界*/
            int l = lowerBount(num - k, nums);
            /*计算第一个大于num-k的元素的索引*/
            int r = lowerBount(num + k + 1, nums);
            /*是数组中第一个大于等于 num 的位置。也就是说，找到一个数字等于 num 或者大于 num 的位置*/
            int l2 = lowerBount(num, nums);
            /*这行代码找的是第一个大于 num + k * 2 的位置*/
            int r2 = lowerBount(num + k * 2 + 1, nums);
            ans = Math.max(ans, Math.min(numOperations, r - l - map.get(num)) + map.get(num));
            ans = Math.max(ans, Math.min(numOperations, Math.min(r2 - l2, numOperations)));

        }
        return ans;

    }

    /*最快的解法  前缀和 统计频率*/
    public int maxFrequency1(int[] nums, int k, int numOperations) {
        int max = 0;
        for (int x : nums)
            if (x > max) max = x;

        /*统计每个数字出现的频次*/
        int[] count = new int[max + 1];
        for (int x : nums)
            count[x]++;
        /*计算前缀和*/
        int[] prefixSum = new int[max + 1];
        int s = 0;
        for (int i = 0; i <= max; i++) {
            s += count[i];
            prefixSum[i] = s;
        }

        /*统计最大频率*/
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            ans = Math.max(ans, Math.min(prefixSum[Math.min(i + k, max)] - prefixSum[Math.max(i - k - 1, 0)], numOperations + count[i]));
        }

        return ans;
    }

    /* 二分查找说明如果中间的数字大于等于目标值 x，那就把右边界 ri
    ght 移动到 m-1，表示继续在左边查找；否则继续在右边查找
    它查找数组中第一个大于等于某个数的位置*/
    private int lowerBount(int x, int[] nums) {
        int l = 0, right = nums.length - 1;
        while (l <= right) {
            int m = l + right >> 1;
            if (nums[m] >= x) {
                right = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        MaxFrequency maxFrequency = new MaxFrequency();
        System.out.println(maxFrequency.maxFrequency(new int[]{1, 4, 5}, 1, 2));
    }
}
