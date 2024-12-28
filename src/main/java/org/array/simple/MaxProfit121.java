package org.array.simple;

public class MaxProfit121 {
    public static int maxProfit(int[] prices) {
        int ans=0;
        for (int i = 0; i < prices.length-1; i++) {
            int buy=prices[i];
            for (int j = i+1; j < prices.length; j++) {
                int sell=prices[j];
                ans=Math.max(ans,sell-buy);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
