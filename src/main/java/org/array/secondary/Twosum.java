package org.array.secondary;

import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/8 下午10:06
 */
public class Twosum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int[] res=new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
