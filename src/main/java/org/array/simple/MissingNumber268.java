package org.array.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber268 {
    public static int missingNumber(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return len;
    }
    public static int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }
    public static int missingNumber2(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }


    public static void main(String[] args) {
        int[] nums={3,0,1};
        System.out.println(missingNumber2(nums));
    }
}
