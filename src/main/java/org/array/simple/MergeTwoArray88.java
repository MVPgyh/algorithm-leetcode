package org.array.simple;

import java.util.Arrays;
import java.util.Collections;

public class MergeTwoArray88 {
    //不能通过
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {

            }
        }
        System.out.println(Arrays.toString(nums1));
        for (int i = 0; i < nums1.length; i++) {
            if (i >= m) {
                nums1[i]=nums2[i-m];
            }
        }
        Arrays.sort(nums1);
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n){
        for (int i = 0; i < nums2.length; i++) {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }

    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int[] n1={0};
        int[] n2={1};
       /*merge(n1,0,n2,1);
       merge1(n1,0,nums2,1);*/

    }
}
