package org.array.simple;

import java.util.*;

public class Insertection349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2);
        System.out.println(set1);
        set1.addAll(list);
        return set1.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[]nums1 = {1,2,2,1};
        int[]nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
