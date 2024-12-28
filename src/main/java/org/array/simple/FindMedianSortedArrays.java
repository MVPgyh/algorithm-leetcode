package org.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/26 下午11:03
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        double result=0;
        int point1=0,point2=0;
        while (point1 != len1 && point2 != len2) {
            if (nums1[point1] < nums2[point2]) {
                list.add(nums1[point1]);
                point1++;
                continue;
            }
            if (nums1[point1] > nums2[point2]) {
                list.add(nums2[point2]);
                point2++;
                continue;
            }
            if (nums1[point1] == nums2[point2]) {
                list.add(nums2[point2]);
                list.add(nums1[point1]);
                point2++;
                point1++;
            }
        }
        if (point1 == len1) {
            for (int i = point2; i < len2; i++) {
                list.add(nums2[i]);
            }
        }
        if (point2 == len2 ) {
            for (int i = point1; i < len1; i++) {
                list.add(nums1[i]);
            }
        }
        /*是奇数*/
        if ((len2 + len1) % 2 == 1) {
            int middle = list.size() / 2 ;
            return list.subList(middle, middle+1).get(0);
        }else {
            int firstNum = list.size() / 2-1 ;
            int secondNum = (list.size() / 2) ;
            List<Integer> integers = list.subList(firstNum, secondNum + 1);
            result= (double) (integers.get(0) + integers.get(1)) /2;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1={1,3};
        int[] num2={2};
        int[] ints = Arrays.copyOf(num1, num1.length);
        System.out.println(Arrays.toString(ints));
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
