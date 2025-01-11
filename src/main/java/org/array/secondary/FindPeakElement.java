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
        /*二分查找*/
        while (l < r) {
            /*中间数字*/
            int mid = l + r >> 1;
            /*如果中间数大于后面一个数 则right=mid 再往左查*/
            if (nums[mid] > nums[mid + 1]) r = mid;
            /*若不大于后面的数字 则left=mid+1 往右查*/
            else l = mid + 1;
        }
        return r;
    }

    /*模拟法*/
    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (i - 1 >= 0) {
                if (nums[i - 1] >= nums[i]) ok = false;
            }
            if (i + 1 < n) {
                if (nums[i + 1] >= nums[i]) ok = false;
            }
            if (ok) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1, 3, 1}));
    }

}
