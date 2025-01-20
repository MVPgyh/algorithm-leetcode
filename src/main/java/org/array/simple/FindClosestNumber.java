package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/20 下午9:32
 */
public class FindClosestNumber {
    /*如果 ∣nums[i]∣ 比答案的绝对值更小，则更新答案为 nums[i]。
    如果 ∣nums[i]∣ 和答案的绝对值相同，且 nums[i]>0，则更新答案为 nums[i]。*/
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int x : nums) {
            if (Math.abs(x) < Math.abs(ans) || Math.abs(x) == Math.abs(ans) && x > 0) {
                ans = x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, 4, 8};
        FindClosestNumber findClosestNumber = new FindClosestNumber();
        System.out.println(findClosestNumber.findClosestNumber(arr));
    }
}
