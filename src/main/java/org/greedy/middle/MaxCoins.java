package org.greedy.middle;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/22 下午9:53
 */
public class MaxCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res=0,len=piles.length,g=len/3;
        int index=0,right=len-1;
        while (index < g) {
            res+=piles[right-1];
            right=right-2;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        int[] arr={9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins.maxCoins(arr));
    }
}
