package org.array.simple;

import java.util.Arrays;

/*
* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
* ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* */
public class Searchbinary704 {
    public static int search(int[] nums, int target) {
        //数组的二分搜索方法
        /*int i = Arrays.binarySearch(nums, target);
        return i;*/
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return  -1;
    }
    public static int search1(int[] nums, int target) {
        int left=0;
        int rigth=nums.length-1;
        while (left <= rigth) {
            int mid=(left+rigth)/2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                rigth=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1,0,3,5,9,12};
        int search = search(ints, 9);
        System.out.println(search);
        int b=-1;
        //输出补码形式
        System.out.println(Integer.toBinaryString(b));
        System.out.println(b>>>1);
    }
}
