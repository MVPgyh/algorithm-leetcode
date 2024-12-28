package org.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    //笨蛋方法
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                Integer it = hm.get(nums[i]);
                hm.put(nums[i],++it);
            }else {
                hm.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return -1;
    }


    //异或运算
    public static  int singleNumber1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
           nums[0]^=nums[i];
        }
        return nums[0];
    }



    public static void main(String[] args) {
//        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }
}
