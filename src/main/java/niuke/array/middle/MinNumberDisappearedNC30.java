package niuke.array.middle;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @Author pudding
 * @Date 2023/11/22 19:03
 */
public class MinNumberDisappearedNC30 {

    public static int minNumberDisappeared(int[] nums) {
        // write code here
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        //哈希表记录数组中出现的每个数字
        for(int i = 0; i < n; i++)
            mp.put(nums[i], 1);
        int res = 1;
        //从1开始找到哈希表中第一个没有出现的正整数
        while(mp.containsKey(res)){
            res++;
        }
        return res;
    }

    public static int minNumberDisappeared1(int[] nums) {
        // write code here
        int nlen = nums.length;
        Arrays.sort(nums);

        int com=1;
       while (com<=nlen){
           int i1 = Arrays.binarySearch(nums, com);
           if (i1 < 0) {
               return  com;
           }
           com++;
       }


        return com;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2};
//        System.out.println(minNumberDisappeared(a));
        System.out.println(minNumberDisappeared1(a));
    }

}
