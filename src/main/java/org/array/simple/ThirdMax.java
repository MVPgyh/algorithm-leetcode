package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/3 下午10:50
 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <3) {
            return nums[nums.length - 1];
        }
        int temp=1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                temp+=1;
            }
            if (temp == 3) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr={2,2,3,1};
        System.out.println(thirdMax(arr));
    }
}
