package org.array.simple;

import java.util.ArrayList;

class NumArray {

    int[] res;
    public NumArray(int[] nums) {
        res = nums;
    }
    
    public int sumRange(int left, int right) {
        int[] preNums = new int[res.length+1];
        for (int i = 1; i < preNums.length; i++) {
           preNums[i]=preNums[i-1]+res[i-1];
        }
        return preNums[right+1]-preNums[left];

    }

    public static void main(String[] args) {
        int[] a={-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(a);
        System.out.println(numArray.sumRange(0, 5));

    }
}