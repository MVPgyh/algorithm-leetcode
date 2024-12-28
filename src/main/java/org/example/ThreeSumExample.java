package org.example;

import java.util.*;
import java.util.function.Consumer;

public class ThreeSumExample {

    /*使用双指针法*/
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[k]);
                        lists.add(al);
                    }
                }
            }
        }
        String s="";
        Iterator<List<Integer>> listIterator = lists.iterator();
        for (int i = lists.size()-1; i >0; i--) {
            List<Integer> integers = lists.get(i);
            if (integers.equals(lists.get(i - 1))) {
                lists.remove(integers);
            }
        }

        return lists;

    }
    public static void main(String[] args) {

    }
}
