package org.array.simple;

import java.util.HashMap;

public class ContainsNearbyDuplicate219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        System.out.println(hm.get(0));
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])&&k>=Math.abs(hm.get(nums[i])-i)) {
                return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,1};
       int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
