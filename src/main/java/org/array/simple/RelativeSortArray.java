package org.array.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午6:58
 */
public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        /*得到arr1数组最大的值*/
        int upper = 0;
        /*采用计数排序 创建一个数组，长度等于=待排序数组最大值 +1  */
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        /*对arr1数组 值为frequency的下标 值为1，有多个相同的值则相加*/
        for (int x : arr1) {
            ++frequency[x];
        }
        /*创建结果数组 大小和arr1一样*/
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; i++) {
                ans[index++] = x;

            }
            frequency[x] = 0;
        }
        /*对还未 再arr2出现的元素 */
        for (int i = 0; i < upper + 1; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;


    }

    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
//        自定义排序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : arr1) {
            list.add(x);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (map.containsKey(x) || map.containsKey(y))
                    return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
                return x - y;
            }
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;

    }

    public static void main(String[] args) {
//        [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        int[] a = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] b = {2, 1, 4, 3, 9, 6};
        int[] ints = relativeSortArray(a, b);
    }
}
