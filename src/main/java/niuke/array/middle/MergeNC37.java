package niuke.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class MergeNC37 {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {


        // write code here
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            return res;
        }
//        谁小谁在前面
        intervals.sort((o1, o2) -> {
            if (o1.start != o2.start)
                return o1.start - o2.start;
            else
                return o1.end - o2.end;
        });

        //添加第一个节点  o1代表第二个节点 origin代表第一个节点
        res.add(intervals.get(0));
        int count = 0;
//        从第一个依次遍历
        for (int i = 1; i < intervals.size(); i++) {
            Interval o1 = intervals.get(i);
            Interval origin = res.get(count);
            if (o1.start > origin.end) {
                res.add(o1);
                count++;
                //区间有重叠，更新结尾
            } else {
                res.remove(count);
                Interval s = new Interval(origin.start, o1.end);
                if (o1.end < origin.end)
                    s.end = origin.end;
                res.add(s);
            }
        }
        return res;


    }

    public ArrayList<Interval> merge1(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>() ;
        if(intervals == null || intervals.size() == 0) return res ;
        //先按start排序
        Collections.sort(intervals , (int1 ,int2)->int1.start - int2.start) ;
        int i = 0 ;//指向每一个区间的开始
        int j = 0 ;//寻找合并区间的 终点
        while(i < intervals.size()) {
            int nextEnd = intervals.get(i).end ;//保存每一段区间的最大终点
            j = i + 1 ;
            while(j < intervals.size() && intervals.get(j).start <= nextEnd) {
                //更新最大终点
                if(intervals.get(j).end > nextEnd) nextEnd = intervals.get(j).end ;
                j ++ ;
            }
            //保存合并后的区间
            res.add(new Interval(intervals.get(i).start , nextEnd)) ;
            i = j ;
        }
        return res ;
    }

    public static void main(String[] args) {
        MergeNC37 mergeNC37 = new MergeNC37();
        Interval i1 = mergeNC37.new Interval(0, 10);
        Interval i2 = mergeNC37.new Interval(10, 20);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        System.out.println();


    }
}