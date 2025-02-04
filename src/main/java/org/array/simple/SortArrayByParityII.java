package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/4 下午9:46
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int len=nums.length;
        int[] res=new int[len];
        int i=0;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[i]=num;
                i+=2;
            }
        }
        i=1;
        for (int num : nums) {
            if (num % 2 == 1) {
                res[i]=num;
                i+=2;
            }
        }
        return res;
    }

    /*双指针解法*/
    public int[] sortArrayByParityII1(int[] nums) {
        int len=nums.length;
        int j=1;
        for (int i = 0; i < len; i+=2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j+=2;
                }
                swap(nums,i,j);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
