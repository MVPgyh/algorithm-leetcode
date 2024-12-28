package org.array.simple;

import java.util.Arrays;

//数组的最大美丽值2779
/**/
public class MaximumBeauty2779 {
    //滑动窗口解法 ，
    //维护一个滑动窗口[l, r]，[l, r]的元素最小值与最大值相差不超过2 * k，
    // 那么[l, r]内所有的元素都可以变成一个值。
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0,n=nums.length;
        for (int l = 0,r=0; r <n ;r++) {
            while (nums[r]>nums[l]+2*k) l++;
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = maximumBeauty(new int[]{4,6,1,2}, 2);
        System.out.println(i);
    }
}
