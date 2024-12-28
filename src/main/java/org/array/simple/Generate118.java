package org.array.simple;

import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <i+1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));

    }
}
