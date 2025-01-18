package thoughts;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午10:41
 */
public class SortByQuick {
    public void sortByquick(int[] nums, int left, int right) {
        if (left < right) {
            int low=left,high=right;
            int pivot=nums[low];
            while (low < high) {
                while (low < high && nums[high] > pivot) {
                    high--;
                }
                nums[low]=nums[high];
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                nums[high]=nums[low];
            }
            nums[low]=pivot;
            sortByquick(nums,left,low-1);
            sortByquick(nums,low+1,right);
        }


    }

    public int[] partition(int[] nums) {
        sortByquick(nums,0,nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr={21,12,43,21,54,32,4,20};
        SortByQuick sortByQuick = new SortByQuick();
        System.out.println(Arrays.toString(sortByQuick.partition(arr)));
    }
}
