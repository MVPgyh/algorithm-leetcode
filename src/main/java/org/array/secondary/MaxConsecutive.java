package org.array.secondary;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/6 下午11:09
 */
public class MaxConsecutive {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int start = special[0] - bottom;
        int end = top - special[special.length - 1];
        int res = Math.max(start, end);
        for (int i = 0; i < special.length - 1; i++) {
            res = Math.max(res, special[i + 1] - special[i]-1);
        }
        return res;
    }

    public static void main(String[] args) {
        int b=2,t=9;
        int[] arr={4,6};
        MaxConsecutive consecutive = new MaxConsecutive();
        System.out.println(consecutive.maxConsecutive(b, t, arr));
    }
}
