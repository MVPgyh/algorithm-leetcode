package org.array.preSum;

import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午10:13
 */
public class CheckSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        /*如果小于2直接返回false*/
        int m=nums.length;
        if (m < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int remainder=0;

        for (int i = 0; i <m; i++) {
            remainder=(remainder+nums[i])%k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0},1));
    }
}
