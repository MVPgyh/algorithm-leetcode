package org.array.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

}
