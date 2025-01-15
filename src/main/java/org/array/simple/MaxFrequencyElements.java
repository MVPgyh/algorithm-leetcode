package org.array.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/15 下午9:34
 */
public class MaxFrequencyElements {
    public int maxFrequencyElements(int[] nums) {
        int len=nums.length,res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            max=Math.max(value,max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == max) {
                res+=value;
            }
        }
        return res;
    }

    /*时间复杂度较低的解法*/
    public static int maxFrequencyElements1(int[] nums) {
        int[] cnt = new int[101];
        int maxFreq = 0, maxCnt = 0;
        for (int num : nums) {
            cnt[num]++;
            /*如果当前元素出现的频率大于最大值，则把频率设为该值，并且更改元素个数为1*/
            if (cnt[num] > maxFreq) {
                maxFreq = cnt[num];
                maxCnt = 1;
                /*如果两个数出现的频率相等的话 则元素数+1 */
            } else if (maxFreq == cnt[num]) {
                maxCnt++;
            }
        }
        return maxCnt * maxFreq;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements1(new int[]{1, 2, 2, 3, 1, 4}));
    }
}
