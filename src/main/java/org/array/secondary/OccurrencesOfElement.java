package org.array.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/30 下午8:39
 */
public class OccurrencesOfElement {
    public static void main(String[] args) {
        OccurrencesOfElement occurrencesOfElement = new OccurrencesOfElement();
        int[] a={1,3,1,7};
        int[] b={1,3,2,4};
        occurrencesOfElement.occurrencesOfElement1(a,b,1);
    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (indices.size() < queries[i]) {
                res[i] = -1;
            } else {
                res[i] = indices.get(queries[i] - 1);
            }
        }
        return res;


    }
    public int[] occurrencesOfElement1(int[] nums, int[] queries, int x) {

        int j = 0;
        int tmp = -1;
        for (int i = 0; i < nums.length; i++) {
            tmp = nums[i];
            nums[i]=-1;
            if (tmp == x) {
                nums[j] = i;
                j++;
            }

        }
        for (int t = 0; t < queries.length; t++) {
            if(queries[t]>nums.length){
                queries[t] = -1;
            }else queries[t] = nums[queries[t]-1];
        }
        return queries;


    }
}
