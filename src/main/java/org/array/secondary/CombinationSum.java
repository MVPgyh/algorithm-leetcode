package org.array.secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/9 下午9:32
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*返回结果集*/
        ArrayList<List<Integer>> ans = new ArrayList<>();
        /*相加等于target的集合*/
        ArrayList<Integer> combine = new ArrayList<>();
        /*回溯算法 传入参数：数组 target 当前收集的集合 index从0开始*/
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    /*回溯算法*/
    private void dfs(int[] candidates, int target, ArrayList<List<Integer>> ans, ArrayList<Integer> combine, int idx) {
        /*如果为最后一个元素 说明走到底了，返回空*/
        if (idx == candidates.length) {
            return;
        }
        /*如果当前target==0说明 每个数相加刚好为target 添加到结果集中*/
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        /*回溯 下一个节点*/
        dfs(candidates, target, ans, combine, idx + 1);
        /*若target减去当前数大于等于0  把当前值添加到combine中 */
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            /*这时候target减去当前值，idx不变，因为可以有重复的数字*/
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            /*如何收集到的结果 回溯时就把该结果吐出来*/
            combine.remove(combine.size() - 1);
        }
    }
}
