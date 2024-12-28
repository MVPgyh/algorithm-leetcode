package org.array.simple;

public class MaxCount2_598 {
    public static int maxCount2(int m, int n, int[][] ops) {
        int mina=m,minb=n;
        for (int[] op : ops) {
            mina=Math.min(mina,op[0]);
            minb=Math.min(minb,op[1]);
        }
        return mina*minb;
    }

    public static void main(String[] args) {
    }
}
