package org.array.simple;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return  new ArrayList<String>();
        }
        ArrayList<String> reslut = new ArrayList<>();
        int pointRight=nums[0],pointLeft=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (pointLeft == pointRight) {
                    reslut.add(String.valueOf(pointLeft));
                    pointLeft=nums[i];
                    pointRight=nums[i];
                    continue;
                }
                reslut.add(pointLeft+"->"+pointRight);
                pointLeft=nums[i];
                pointRight=nums[i];
                continue;
            }
            pointRight=nums[i];

        }
        if (pointLeft == pointRight) {
            reslut.add(String.valueOf(pointLeft));
        }else {
            reslut.add(pointLeft+"->"+pointRight);
        }

        return reslut;

    }

    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
