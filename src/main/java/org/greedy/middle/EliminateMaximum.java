package org.greedy.middle;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/16 下午10:31
 */
/*贪心+排序*/
    /*向上取整 */
public class EliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        /*怪物到达时间*/
        int[] times=new int[n];
        /*向上取整*/
        for (int i = 0; i < n; i++) {
            /*向上取整的方法 好办法 但不适用于负数*/
            times[i]=(dist[i]-1)/speed[i]+1;
        }
        /*排序*/
        Arrays.sort(times);
        System.out.println(Arrays.toString(times));
        /*遍历*/
        for (int i = 0; i < n; i++) {
            /*如果 times[i]>i，说明第 i 个怪物可以被消灭 这里必须用等于号*/
            /*0 1 2*/
            if (times[i] <= i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        EliminateMaximum delete = new EliminateMaximum();
        int[] dist = {1,3,4};
        int[] speed = {1,3,1};
        System.out.println(delete.eliminateMaximum(dist, speed));
    }
}
