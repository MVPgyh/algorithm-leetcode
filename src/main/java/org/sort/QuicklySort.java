package org.sort;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/7 下午9:36
 */
public class QuicklySort {
    public static void main(String[] args) {
        QuicklySort quicklySort = new QuicklySort();
        System.out.println(Arrays.toString(quicklySort.sortArray(new int[]{21,12,43,21,54,32,4,20})));
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public static void quickSort(int nums[], int start, int end) {
        //数组有多个元素进行排序
        if (start < end) {
            int base = nums[start];//以要进行排序数组第0个元素为base
            int left = start;//左指针
            int right = end;//右指针
            while (left < right) {
                //从右向左找，比base大，right--
                while (left< right && nums[right] >= base) {
                    right--;
                }
                //比base小，替换left所在位置的数字
                nums[left] = nums[right];
                //从左向右找，比base小，left++
                while (left < right && nums[left] <= base){
                    left++;
                }
                //比base大，替换right所在位置的数字
                nums[right] = nums[left];
            }
            nums[left] = base;//此时left=right，用base替换这个位置的数字
            //排列比base小的数字的数组
            quickSort(nums, start, left - 1);
            //排列比base大的数字的数组
            quickSort(nums, left + 1, end);
        }
    }



}
