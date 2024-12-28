package niuke.array.middle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author pudding
 * @Date 2023/11/24 21:21
 */
public class SubsetsNC27 {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //排序
        Arrays.sort(S);
//        S是数组  result是返回结果  temp是当前要添加的  start是开始的索引
        dfs(S, result, temp, 0);
        return result;
    }

    public static void dfs(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int start) {
        //当前加入到result中
        result.add(new ArrayList<>(temp));
        for (int i = start; i < num.length; i++) {
            //将当前值加入temp中
            temp.add(num[i]);
//            回溯跟递归有关  四个参数 数组 结果 起始位置
            dfs(num, result, temp, i + 1);
            //回溯到上一层  回到上一个节点
            temp.remove(temp.size() - 1);

        }
    }


    public static void main(String[] args) {
        int[] a={1,2,3,4};
        System.out.println(subsets(a));

    }
}
