package org.array.secondary;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/13 下午8:27
 */
public class WaysToSplitArray {
    public static int waysToSplitArray(int[] nums) {
        int n=nums.length;
        /*这里用long存 int可能会溢出*/
        long left=0,right=0;
        for (int num : nums) {
            right+=num;
        }
        int ans=0;
        for (int i = 0; i < n - 1; i++) {
            left+=nums[i];
            right-=nums[i];
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{2,3,1,0}));
    }
}
