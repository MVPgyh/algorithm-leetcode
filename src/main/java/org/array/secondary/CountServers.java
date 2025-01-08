package org.array.secondary;

import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/8 下午10:04
 */
public class CountServers {
    /*本体用两次遍历 解决问题 */
    public static int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //row 中存储行的编号以及每一行服务器的数量，col 存储列的编号以及每一列服务器的数量。
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.put(i, rows.getOrDefault(i, 0) + 1);
                    cols.put(j, cols.getOrDefault(j, 0) + 1);
                }
            }
        }
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /*用数组存储 效率快很多*/
    public int countServers1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 用于记录每行和每列的服务器数量
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // 第一次遍历，统计每行和每列的服务器数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int result = 0;

        // 第二次遍历，统计能够与至少一台其他服务器进行通信的服务器的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {1, 1}};
        System.out.println(countServers(arr));
    }
}
