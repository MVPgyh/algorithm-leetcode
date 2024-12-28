package org.array.simple;

import java.util.Arrays;

public class IslandPerimeter463 {
    //自己解题方法  时间复杂度高
    public static int islandPerimeter(int[][] grid) {
        int perimeter=0;
        int len = grid.length;
        int col=grid[0].length;
        int[][] periphery = new int[len + 2][col+ 2];
        for (int i = 0; i < periphery.length; i++) {
            for (int j = 0; j < periphery[i].length; j++) {
                if (i == 0 || i==periphery.length-1 ||j==0|| j == periphery[i].length - 1) {
                    periphery[i][j]=0;
                    continue;
                }
                periphery[i][j]=grid[i-1][j-1];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < col; j++) {
                int i1 = grid[i][j];
                if (i1 == 1) {
                    int arg=4;
                    int left = periphery[i + 1][j] == 1 ? --arg : 0;
                    int right = periphery[i + 1][j+2] == 1 ? --arg : 0;
                    int top = periphery[i][j+1] == 1 ? --arg : 0;
                    int bottom = periphery[i + 2][j+1] == 1 ? --arg : 0;
                    perimeter+=arg;
                }
            }
        }
        return perimeter;
    }
//    最高效方法

    public static int isllandPerimeter1(int[][] grid) {
//存储上一行的数组
        int[] arr = new int[grid[0].length];
        int res = 0;
        for (int[] row : grid) {
            //遍历当前行
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    //如果当前格子为陆地，周长+4
                    res += 4;
                    //检查同列上一行是否是陆地 是的话 减去重复边
                    res -= arr[i] * 2;
                    //如果该格子不是边界格子则检查前一个格子是否是陆地
                    if (i > 0) {
                        res -= row[i - 1] * 2;
                    }
                }
            }
            arr = row;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints ={{0, 1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] ints1 ={{0,1}};
        System.out.println(islandPerimeter(ints1));
    }
}
