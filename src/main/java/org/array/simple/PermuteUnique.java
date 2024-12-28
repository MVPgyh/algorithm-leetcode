package org.array.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 中等题 回溯算法
 * 遗留问题
 * */
public class PermuteUnique {
    static boolean[] vis;

    //思路  进行全排列 然后比较去重  解题失败
    public static List<List<Integer>> quUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                row.add(nums[j]);
            }
            res.add(row);
        }
        return res;
    }

    //搜索回溯 官方解法 回溯算法
    public static List<List<Integer>> quUnique1(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    //回溯函数  参数分别为被排列数组，返回的结果集，索引的开始位置，结果集中的一个元素；
    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
//        判断 index是否等于数组的长度，如果相等结果集加上perm 结束函数
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        //每一个数字循环一次
        //回溯是循环里面套着递归
        for (int i = 0; i < nums.length; i++) {
            //判断vis是否为假的，或者 i>0并且数组元素等于数组的前一个元素并且vis前一个不为假
            //跳过本次循环
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            // 否则perm集合中添加  对应数组元素
            perm.add(nums[i]);
            //添加完元素给vis赋值为真
            vis[i] = true;
            //执行下一次递归
            backtrack(nums, ans, idx + 1, perm);
            //使vis的值为false
            vis[i] = false;
            //perm中移除刚添加的元素
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
//        System.out.println(quUnique(new int[]{1, 1, 2}));
    }
}
