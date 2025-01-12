package org.array.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 上午10:42
 */
public class MergeArr {
    /*暴力方法*/
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            A[i] = B[j];
        }
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
    }

    /*双指针法 时间复杂度为m+n*/
    public void merge1(int[] A, int m, int[] B, int n) {
        /*定义两个指针分别指向数组第一个数字*/
        int pa = 0, pb = 0;
        /*定义一个大小为n+m的数组*/
        int[] sorted = new int[m + n];
        /*当前元素*/
        int cur;
        /*终止条件：pa！=m并且 pb！=n*/
        while (pa < m || pb < n) {
            /*如果pa=m 则当前元素为pb所指向的值，如果pb=n 说明n循环完了 则当前元素为pa指向元素
             * 如果pa小于pb，则cur=pa，否则等于pb
             * */
            if (pa == m) {
                cur = B[pb++];
            } else if (pb == n) {
                cur = A[pa++];
            } else if (A[pa] < B[pb]) {
                cur = A[pa++];
            } else {
                cur = B[pb++];
            }
            /*因为pa或pb已经加一 所以这里要减一*/
            sorted[pa + pb - 1] = cur;
        }
        /*把sorted赋值给 A数组 才可得到正确结果*/
        for (int i = 0; i != m + n; i++) {
            A[i] = sorted[i];
        }
    }

    /*逆向双指针*/
    /*A 的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 A 的最后面*/
    public void merge2(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }


    public static void main(String[] args) {
        MergeArr mergeArr = new MergeArr();
        mergeArr.merge1(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
