package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午3:33
 */
public class MaxProfit2 {
    /*买卖股票的最佳实际 1*/
    public int maxProfit1(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
          /*res= Math.max(res,prices[i]-min);
          min=Math.min(min,prices[i]);*/

            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    /*买卖股票的最佳时机2*/
    /*只要当天比前一天的值大 就加入到结果集中*/
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res+=prices[i]-prices[i-1];
            }
        }
        return  res;
    }
}
