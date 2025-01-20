package org.array.preSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午10:13
 */
/*连续的子数组和*/
public class CheckSubarraySum {
    /*涉及到一个同余定理  同余定理：如果两个整数m、n满足n-m能被k整除，那么n和m对k同余*/
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

    public static boolean checkSubarraySum1(int[] nums, int k) {
        int len=nums.length;
        int[] prearr=new int[len+1];
        /*求数组前缀和*/
        for (int i = 0; i < len; i++) {
            prearr[i+1]=prearr[i]+nums[i];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <=len ; i++) {
            set.add(prearr[i - 2] % k);
            if (set.contains(prearr[i] % k)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0},1));
        checkSubarraySum1(new int[]{1,2,1},1);
    }
}
