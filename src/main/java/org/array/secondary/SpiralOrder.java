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
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows=matrix.length,columns=matrix[0].length;
        boolean[][] visited=new boolean[rows][columns];
        int total=rows*columns;
        int row=0,column=0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex=0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column]=true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;

    }
}
