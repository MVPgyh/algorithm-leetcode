package org.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count=0;
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int sum=hm.get(nums[i])+1;
                hm.put(nums[i],sum);
            }else {
                hm.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            count=Math.max(count,entry.getValue());
        }
        System.out.println(hm);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue()==count) {
                ans=entry.getKey();
            }
        }
        return ans;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return  nums[nums.length/2];
    }
    public static int majorityElement2(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public static void main(String[] args) {
        int[] nums={3,2,3};
        System.out.println(majorityElement2(nums));


    }
}
