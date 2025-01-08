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



    /*解法1：采用递归法*/
    public int minimumTotal1(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        /*结束条件 为到达底部*/
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /*解法二 递归+记忆化*/
    Integer[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle) {
        /*创建一个triangle大小的二维数组 进行记忆*/
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs2(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /*解法三：动态规划*/
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
