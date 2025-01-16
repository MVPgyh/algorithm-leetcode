package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/16 下午8:56
 */
/*滑动窗口*/
public class MinimumSubarrayLength {
    /*枚举暴力循环*/
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        /*遍历数组中的每一个数字*/
        for (int i = 0; i < n; i++) {
            /*定义值为0*/
            int value=0;
            /*从i开始 不用和前面的比较 因为已经比较过了*/
            for (int j = i; j < n; j++) {
                /*计算value*/
                value|=nums[j];
                if (value >= k) {
                    res=Math.min(res,j-i+1);
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    /*第二种方法 滑动窗口*/
    public int minimumSubarrayLength1(int[] nums, int k) {
        int n=nums.length;
        int[] bits=new int[30];
        int res=Integer.MAX_VALUE;
        for (int left = 0,right=0; right<n; right++) {
            for (int i = 0; i < 30; i++) {
                bits[i]+=(nums[right]>>i)&1;
            }
            /*calc判断滑动窗口的或是不是大于等于k*/
            while (left <= right && calc(bits) >= k) {
                res=Math.min(res,right-left+1);
                for (int i = 0; i < 30; i++) {
                    bits[i]-=(nums[left]>>i)&1;
                }
                /*缩减窗口*/
                left++;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    private int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        MinimumSubarrayLength ke = new MinimumSubarrayLength();
        ke.minimumSubarrayLength1(new int[]{10,2,3},2);
        int ans = 11;
        int[] bits={1,1,0,1};
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= 1 << i;
                System.out.println(ans);
            }
        }
        System.out.println(ans);
    }
}
