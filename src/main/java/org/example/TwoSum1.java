package org.example;

import java.util.HashMap;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int need=target-nums[i];
            if (hm.containsKey(need)) {
                return new int[]{hm.get(need),i};
            }
            hm.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
