package org.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement229 {
    public static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int curr_num=nums[0],count=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr_num) {
                count++;
            } else {
                curr_num=nums[i];
                count=1;
            }
            if (count > nums.length / 3&&!ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }
    return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,2,1,1,1,1,2,2,1,1};
        int[] nums1={3,2,3};
        System.out.println(majorityElement(nums));
    }
}
