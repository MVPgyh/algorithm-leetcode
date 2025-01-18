package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午1:52
 */
public class FindDuplicate {
    /*用ints存储每个数字出现的次数，最后遍历数组得出个数大于等于2的*/
    public int findDuplicate(int[] nums) {
        int n=nums.length-1,len=nums.length;
        int[] ints = new int[n];
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            ints[cur-1]++;
        }
        for (int i = 0; i < n; i++) {
            if (ints[i] >= 2) {
                return i+1;
            }
        }
        return -1;
    }
    /*二分查找*/
    public int findDuplicate1(int[] nums) {
        int len = nums.length; // n + 1 = len, n = len - 1

        // 在 [1..n] 查找 nums 中重复的元素
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 下一轮搜索的区间 [left..mid]
                right = mid;
            } else {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(arr));
    }
}
