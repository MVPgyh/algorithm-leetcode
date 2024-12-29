package org.array.secondary;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午6:26
 */
public class CanFinish {
    public static void main(String[] args) {
        int[][] array = {{1, 0}, {1, 2}, {0, 1}};
        System.out.println(canFinish(3, array));
    }

    /*广度优先搜索算法  或  深度优先搜索算法 求解*/
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        这个数组用于记录每个课程的入度
        int[] ans = new int[numCourses];
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            res.add(new ArrayList<>());
        }
        /*取出每一对节点*/
        for (int[] temp : prerequisites) {
            ans[temp[0]]++;
            res.get(temp[1]).add(temp[0]);
        }

//        先把所有入度为0的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (ans[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int i : res.get(pre)) {
                if (--ans[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return numCourses == 0;
    }
}
