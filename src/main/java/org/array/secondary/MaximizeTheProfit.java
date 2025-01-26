package org.array.secondary;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/25 下午8:54
 */
public class MaximizeTheProfit {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(1) - b.get(1));
        int m = offers.size();
        int[] dp = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int j = binarySearch(offers, offers.get(i).get(0) - 1, i - 1);
            dp[i + 1] = Math.max(dp[i], dp[j + 1] + offers.get(i).get(2));
        }
        return dp[m];
    }

    public int binarySearch(List<List<Integer>> offers, int maxEnd, int high) {
        int low = -1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (offers.get(mid).get(1) <= maxEnd) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /*简便方法*/
    public int maximizeTheProfit1(int n, List<List<Integer>> offers) {
        //dp[i]表示在当前订单下，出售前i间房时能卖出的最多金币
        int[] dp = new int[n+1];
        Map<Integer,List<int[]>> groups = new HashMap<>();

        //选或不选 => (选的有多个)选哪个
        //按照end分组，因为该房子卖的话，可能有多种方案涉及到，要选最大价值的那套方案
        for(List<Integer> offer: offers){
            List<int[]> group = groups.getOrDefault(offer.get(1),new ArrayList<>());
            group.add(new int[]{offer.get(0),offer.get(2)});
            groups.put(offer.get(1),group);
        }

        for(int end=0;end<n;end++){//不管有没有买end号房的，直接从0遍历到n
            List<int[]> group = groups.getOrDefault(end,new ArrayList<>());
            //既有不选的作用，又能让dp保持连续
            dp[end+1] = dp[end];
            //选,买end号房的方案可能有多个
            for(int[] endOffer:group){
                dp[end+1] = Math.max(dp[end+1],dp[endOffer[0]] + endOffer[1]);
            }
        }

        return dp[n];
    }

}
