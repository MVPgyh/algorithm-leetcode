package org.array.secondary;

import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午10:38
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        int[] arr={72956,-44432,78333,31358,-96449,-24776};
        System.out.println(minimumDeletions(arr));
    }
    /*错误答案  失败告终*/
    public  static int minimumDeletions(int[] nums) {
        int len=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=nums[0];
        int min=nums[0];
        /*把值和索引 存入map中  并记录最大值和最小值*/
        for (int i = 0; i < len; i++) {
            map.put(nums[i],i);
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        Integer maxIndex = map.get(max);
        Integer minIndex = map.get(min);
        int res=0;
        if (minIndex >= len / 2 && maxIndex>=len/2) {
           return len-Math.min(minIndex,maxIndex);
        }else if (minIndex <= len / 2 && maxIndex<=len/2){
           return Math.max(minIndex,maxIndex)+1;
        } else if (minIndex >= len / 2 && maxIndex < len / 2) {

            int hou = len - minIndex;
            int qian = maxIndex + 1;
            if (Math.abs(minIndex - maxIndex) <= hou) {
                return minIndex+1;
            }
            res+=len-minIndex;
            res+=maxIndex+1;
            return res;
        } else if (minIndex < len / 2 && maxIndex >= len / 2) {

            int hou = len - maxIndex;
            int qian = minIndex + 1;
            if (Math.abs(maxIndex - minIndex) <= hou) {
               return maxIndex+1;
            }
            res+=len-maxIndex;
            res+=minIndex+1;
            return res;
        }
        return res;

    }

    public int minimumDeletions1(int[] nums) {
        int minIdx=0,maxIdx=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx=i;
            }
            if (nums[i] > nums[minIdx]) {
                maxIdx=i;
            }
        }
        int max=Math.max(maxIdx,minIdx),min=Math.min(maxIdx,minIdx);
        return Math.min(min+1+nums.length-max,Math.min(max+1,nums.length-min));
    }
}
