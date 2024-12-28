package org.array.simple;

import java.util.ArrayList;
import java.util.List;

public class GetRow119 {
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(1);
            return objects;
        }
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret.get(rowIndex);
    }
    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow1(3));
    }
}
