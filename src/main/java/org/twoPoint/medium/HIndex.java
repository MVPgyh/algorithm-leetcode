package org.twoPoint.medium;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/5 下午11:01
 */
/*数组 二分查找*/
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h=0,i=citations.length-1;
        while(i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;
    }

    /*计数排序*/
    public int hIndex1(int[] citations) {
        int tol=0,n=citations.length;
        int[] counter=new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            }else {
                counter[citations[i]]++;
            }
        }
        for (int i =n; i >=0 ; i--) {
            tol+=counter[i];
            if (tol >= i) {
                return i;
            }
        }

        return 0;
    }
}
