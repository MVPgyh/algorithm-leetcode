package org.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hs.add(nums[i]);
        }
        for (int i = 1; i < len+1; i++) {
            if (!hs.contains(i)) {
                al.add(i);
            }
        }
        return al;
    }
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int len=nums.length;
        for (int num : nums) {
            int x=(num-1)%len;
            nums[x]+=len;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers1(nums));

    }
}
