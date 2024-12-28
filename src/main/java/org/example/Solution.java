package org.example;

import java.util.*;

class Solution {
    public static List<Long> maximumEvenSplit(long finalSum) {
        ArrayList<Long> al = new ArrayList<>();
        if ((finalSum & 1) == 1) return al;
        for (long i = 2L; i <= finalSum; i += 2) {
            finalSum -= i;
            if ((2 * i - 2) >= finalSum) {
                if (finalSum <= i) {
                    al.add(finalSum + i);
                    break;
                }
                al.add(i);
                al.add(finalSum);
                break;
            }
            al.add(i);
        }
        return al;

    }

    //冒泡排序
    public static int[] popsort(int[] nums) {
        int temp;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return  nums;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        //二维数组按照第一行排序
        Arrays.sort(data, (data1, data2) -> data1[0] - data2[0]);
        System.out.println(Arrays.deepToString(data));
        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }
    public static void main(String[] args) {
//        System.out.println(maximumEvenSplit(8));
        int[] nums={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
        int[] arrays = new int[101];
        for (int num : nums) {
            arrays[num]=arrays[num]+1;
        }
        System.out.println(Arrays.toString(arrays));
        for (int i = 1; i < arrays.length; i++)
            arrays[i] += arrays[i - 1];
        System.out.println(Arrays.toString(arrays));
    }
}