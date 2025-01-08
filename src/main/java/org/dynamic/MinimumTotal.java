package org.dynamic;

import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/8 下午11:19
 */
/*动态规划*/
public class MinimumTotal {
    public static void main(String[] args) {

    }

    /*动态规划*/
    public int minimumTotal(List<List<Integer>> triangle) {
        /*n为有几层*/
        int n = triangle.size();
        /*创建一个n*n得二维数组*/
        int[][] f = new int[n][n];
        /*获取一层得第一个数字*/
        f[0][0] = triangle.get(0).get(0);
        /*从第二层开始遍历*/
        for (int i = 1; i < n; i++) {
            /*i0是*/
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[n - 1][i]);

        }
        return minTotal;
    }
}
