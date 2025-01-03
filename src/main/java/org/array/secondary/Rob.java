package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/3 下午9:49
 */
public class Rob {
    public int rob(int[] nums) {
        int evenSum=0,oddSum=0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                oddSum+=nums[i];
            }else {
                evenSum+=nums[i];
            }
        }
       return Math.max(evenSum,oddSum);

    }
}
