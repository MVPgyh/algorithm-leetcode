package org.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/25 下午11:02
 */
public class Twosum {
    public static void main(String[] args) {
        int[] nums={3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0]=map.get(target - nums[i]);
                result[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;

    }
}
