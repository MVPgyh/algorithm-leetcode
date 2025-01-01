package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午10:03
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for (int i = 0; i < nums.length-1; i++) {
            max=Math.max(max,nums[i+1]-nums[i] );
        }
        return max;
    }
}
