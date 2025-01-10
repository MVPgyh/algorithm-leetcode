package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/10 下午11:16
 */
public class FindPeakElement {
    /*寻找峰值 寻找出最大值即可 返回该索引*/
    public int findPeakElement(int[] nums) {
        int inx=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[inx]) {
                inx=i;
            }

        }
        return inx;

    }

    /*二分查找*/
    public int findPeakElement1(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

}
