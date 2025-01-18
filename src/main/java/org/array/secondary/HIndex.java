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
        //结果
        int n = citations.length, tot = 0;
        /*因为H指数不可能大于总的论文发表数*/
        int[] counter = new int[n + 1];
        /*引用次数大于文章数量的放最后*/
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        /*倒叙遍历counter*/
        for (int i = n; i >= 0; i--) {
            /**/
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    /*二分搜索*/
    public int hIndex2(int[] citations) {
        int left=0,right=citations.length;
        int mid=0,cnt=0;
        while(left<right){
            // +1 防止死循环
            mid=(left+right+1)>>1;
            cnt=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=mid){
                    cnt++;
                }
            }
            if(cnt>=mid){
                // 要找的答案在 [mid,right] 区间内
                left=mid;
            }else{
                // 要找的答案在 [0,mid) 区间内
                right=mid-1;
            }
        }
        return left;
    }




    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex1(new int[]{3, 100, 6, 1, 5}));
    }
}
