package org.array.secondary;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午11:13
 */
/*双指针解法 排序*/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int near = Integer.MAX_VALUE;
        /*枚举a*/
        for (int i = 0; i < len; i++) {
            /*保证和上一次枚举不相同 看哔站的代码随想录有讲解*/
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
//           双指针枚举bc
            int j = i + 1, k = len - 1;
//            条件为左小于右
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
//               和target相同直接返回答案
                if (sum == target) {
                    return target;
                }
//                根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(near - target)) {
                    near = sum;
                }
                /*如果和大于target */
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针 k往左移动
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return near;

    }
}
