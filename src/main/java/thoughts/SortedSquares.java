package thoughts;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 下午10:36
 */
/*有序数组的平方*/
public class SortedSquares {
    /*暴力循环大法*/
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /*双指针法*/
    public static int[] sortedSquares1(int[] nums) {
        int left=0,len=nums.length,right=len-1;
        int[] res = new int[len];
        for (int i = len-1; i >= 0; i--) {
            int l = nums[left] * nums[left];
            int j = nums[right] * nums[right];
            if (l > j) {
                res[i]=l;
                left++;
            }else {
                res[i]=j;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares1(new int[]{-7,-3,2,3,11,11})));
    }
}
