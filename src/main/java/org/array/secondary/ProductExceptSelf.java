package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午7:21
 */
/*除自身以外数组的乘积 前缀和 238*/
public class ProductExceptSelf {
    /*两个for循环超时 */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int sum = 1;
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                } else {
                    sum *= nums[j];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    /* 方法一 创建前后缀数组两个数组记录左右乘积列表*/
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] suf = new int[len];
        pre[0] = 1;
        suf[len - 1] = 1;
        /*填充前缀乘积数组*/
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        /*填充后缀乘积数组*/
        for (int i = len - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }

    /*方法二：空间复杂度 O(1) 的方法 删除了后缀数组 少点空间复杂度*/
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        /*从后往前遍历 answer-i */
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }

}
