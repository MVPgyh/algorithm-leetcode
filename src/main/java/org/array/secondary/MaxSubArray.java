package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午2:31
 */
public class MaxSubArray {
    /*这样会超时的 时间复杂度太高*/
    public int maxSubArray(int[] nums) {
        int len = nums.length, res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    /*为动态规划 */
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            curSum=Math.max(nums[i],curSum+nums[i]);
            maxSum=Math.max(curSum,maxSum);

        }
        return maxSum;
    }

    /**/
    public int maxSubArray2(int[] nums) {
        int len = nums.length,res=Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) {
                nums[i]+=nums[i-1];
            }
        }
        for (int i = 0; i < len; i++) {
            res=Math.max(nums[i],res);
        }
        return res;
    }
}
