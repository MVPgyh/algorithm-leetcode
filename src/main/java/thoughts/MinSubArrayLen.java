package thoughts;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 下午10:49
 */
/*最小长度的子数组 中等题*/
public class MinSubArrayLen {
    /*暴力解法 会超时*/
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length, res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp += nums[j];
                if (temp >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /*滑动窗口 TODO 滑动窗口案例 非常有必要背会*/
    public static int minSubArrayLen1(int target, int[] nums) {
        /*idx表示滑动窗口左节点*/
        int len = nums.length, res = Integer.MAX_VALUE, idx = 0, sum = 0;
        /*循环i表示滑动窗口右边界*/
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - idx + 1);
                sum-=nums[idx++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }
}
