package org.array.secondary;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/15 下午8:43
 */
/*这里采用优先级队列 内部实现采用堆数据结构*/
public class MinOperations {
    public int minOperations(int[] nums, int k) {
        int res=0;
        /*priorityQueue 优先级队列*/
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (long num : nums) {
            pq.offer(num);
        }
        while (pq.peek() < k) {
            long x=pq.poll(),y=pq.poll();
            pq.add(x+x+y);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        m.minOperations(new int[]{21,12,32,55,2},10);
    }
}
