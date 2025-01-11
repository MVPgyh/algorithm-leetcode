package thoughts;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 下午10:10
 */
public class Search {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left <= right) {
            int middle=(right-left)/2+left;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left=middle+1;
            }else {
                right=middle-1;
            }
        }
        return -1;
    }
}
