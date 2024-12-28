package niuke.tanxin.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @Date 2023/11/23 19:59
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        // write code here
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;

    }

    public static int maxProfit1(int[] prices) {
        // write code here
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];

    }

    public static void main(String[] args) {
        int[] prices = {8, 9, 2, 5, 4, 7, 1};
        System.out.println(maxProfit(prices));
    }
}
