package org.array.secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午10:38
 */
/*螺旋矩阵 用模拟做*/
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        /*统计行数和列数*/
        int rows = matrix.length, columns = matrix[0].length;
        /*二维布尔数组*/
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;

    }

    /*确定四个边界 实时更新四个边界*/
    public  static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        /*四个指针 左右上下 这里的d是底部 u是顶部 up down*/
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;
        while(u <= d && l <= r){
            /*上遍历*/
            for(int j = l; u <= d && j <= r; j++) {
                res.add(matrix[u][j]);
            }
            u++;
            /*右遍历*/
            for(int i = u; l <= r && i <= d; i++){
                res.add(matrix[i][r]);
            }
            r--;
            /*下遍历*/
            for(int j = r; u <= d && j >= l; j--) {
                res.add(matrix[d][j]);
            }
            d--;
            /*左遍历*/
            for(int i = d; l <= r && i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arrs={{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder1(arrs);
    }
}
