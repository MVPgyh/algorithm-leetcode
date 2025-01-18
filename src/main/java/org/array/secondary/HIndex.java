package org.array.secondary;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午3:56
 */
/*H指数*/
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        /*倒序遍历每个数字*/
        int h = 0, i = citations.length - 1;
        /*如果当前论文被引用数大于h 则h++*/
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /*计数排序*/
    public int hIndex1(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
