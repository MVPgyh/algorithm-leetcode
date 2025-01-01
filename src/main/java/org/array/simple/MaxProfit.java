package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午9:26
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }

        return max;
    }

    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            int[] temp = new int[prices.length];
            System.arraycopy(prices, 0, temp, 0, prices.length);
            Arrays.sort(temp, i + 1, len);
            max = Math.max(max, temp[prices.length - 1] - prices[i]);
        }

        return max;
    }

    public static int maxProfit2(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min=prices[i];
            } else if (prices[i]-min>max) {
                max=prices[i]-min;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(maxProfit1(arr));
    }
}
