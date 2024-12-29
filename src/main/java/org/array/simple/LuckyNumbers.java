package org.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午11:58
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] a={{76618,42558,65788,20503,29400,54116}};
        System.out.println(luckyNumbers(a));
    }
    /*矩阵中的幸运数*/
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int len=matrix.length;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        /*求行的最小值*/
        for (int i = 0; i < len; i++) {
            int[] curRow = matrix[i];
            int rowLen = curRow.length;
            int minRowNum=curRow[0];
            for (int j = 0; j < rowLen; j++) {
                minRowNum=Math.min(minRowNum,curRow[j]);
            }
            list.add(minRowNum);
        }

        /*求列的最大值*/
        int colLen = matrix[0].length;
        for (int i = 0; i < colLen; i++) {
            int max=matrix[0][i];
            for (int j = 0; j < len; j++) {
                max=Math.max(max,matrix[j][i]);
            }
            if (list.contains(max)) {
                res.add(max);
                break;
            }
        }
        return res;
    }
}
