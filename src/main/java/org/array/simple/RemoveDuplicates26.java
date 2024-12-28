package org.array.simple;

import java.util.*;

/**
 * 此题应用双指针解法
 */
public class RemoveDuplicates26 {
//    自己写的菜逼方法 不通过
    public static  int removeDuplicates(int [] nums) {
        Set<Integer> hs = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int [] ans=new int[hs.size()];
        int i=0;
        for (Integer h : hs) {
            ans[i]=h;
            i++;
        }
        return hs.size();

    }

    //原地修改数组 双指针法
    static  int removeDuplicates1(int [] nums){
        int n=nums.length;
        if (n == 0) {
            return 0;
        }
        int fast=1,slow=1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return  slow;
    }
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
