package org.array.secondary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 上午8:58
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        /*把所有的数添加到 output数组中*/
        ArrayList<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n=nums.length;
        /*output为临时数组*/
        backtrack(n,output,res,0);
        return  res;
    }

    /*回溯算法*/
    public void backtrack(int n, ArrayList<Integer> output, ArrayList<List<Integer>> res, int first) {
        /*所有数都填完了 第一个数等于临时数组的长度 */
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        /*从0开始 */
        for (int i = first; i < n; i++) {
            /*动态维护数组 交换output数组中某两个位置的元素*/
            Collections.swap(output, first, i);
            /*继续递归填下一个数字*/
            backtrack(n,output,res,first+1);
            /*撤销操作*/
            Collections.swap(output,first,i);

        }
    }

    public static void main(String[] args) {

    }
}
