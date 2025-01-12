package thoughts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 下午11:55
 */
/*合并区间  模拟法TODO*/
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        /*遍历二维数组*/
        for (int i = 0; i < intervals.length; i++) {
            /*L为当前数组的第一个数，R为第二个数*/
            int L=intervals[i][0],R=intervals[i][1];
            /*如果list的大小为0或者list最后个数组的第二个值小于当前数组的第一个值 说明可以不合并
            * 直接添加到res中*/
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L,R});
                /*否则把最后一个数组的第二个数 替换为相比较的两个数组中第二个数最大的值 相当于合并*/
            }else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        /*返回合并后的数组即可*/
        return merged.toArray(new int[merged.size()][]);
    }

    /*快速解法  时间复杂度低 自制排序*/
    public int[][] merge1(int[][] intervals) {
        int maxEnd = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        int[] diff = new int[maxEnd * 2 + 2];
        for(int[] interval : intervals){
            diff[interval[0] * 2]++;
            diff[interval[1] * 2 + 1]--;
        }
        // 扫描差分数组，合并区间
        List<int[]> result = new ArrayList<>();
        int sumD = 0, left = -1;

        for (int right = 0; right < diff.length; right++) {
            sumD += diff[right];
            if (sumD > 0 && left == -1) {
                // 区间开始
                left = right;
            } else if (sumD == 0 && left != -1) {
                // 区间结束
                result.add(new int[]{left / 2, right / 2});
                left = -1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /*训练*/
    public int[][] merge2(int[][] intervals) {
        /*按数组第一个数升序排列*/
       Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (res.isEmpty() || res.get(res.size() - 1)[1]<curr[0]) {
                res.add(curr);
            }else {
                res.set(res.size()-1,new int[]{res.get(res.size()-1)[0],Math.max(res.get(res.size()-1)[1],curr[1])});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        Merge merge = new Merge();
        System.out.println(Arrays.deepToString(merge.merge2(new int[][]{{1, 3}, {2, 6}, {15, 18},{8, 10}})));
    }
}
