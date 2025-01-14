package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/14 下午11:02
 */
public class MinOperations {
    public static int minOperations(int[] nums, int k) {
        int res=0,len=nums.length;
        for (int i = 0; i <len ; i++) {
            if (nums[i] < k) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={2,11,10,1,3};
        System.out.println(minOperations(arr, 10));
    }
}
