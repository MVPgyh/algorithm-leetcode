package thoughts;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 下午10:13
 */
public class RemoveElement {
    /*快慢指针法*/
    public int removeElement(int[] nums, int val) {
        int left=0,len=nums.length;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left++]=nums[right];
            }
        }
        return left;
    }

    /*循环大法*/
    public int removeElement1(int[] nums, int val) {
        int len=nums.length;
        /*遍历每个数*/
        for (int i = 0; i < len; i++) {
            /*如果当前数等于val 则从下一个数字循环把其他数字前移 并记录len */
            if (nums[i] == val) {
                for (int j = i+1; j < len; j++) {
                    nums[j-1]=nums[j];
                }
                i--;
                len--;
            }
        }
        return len;

    }

    /*双向指针法 */
    public int removeElemen2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement1(new int[]{3,2,2,3}, 3));
    }
}
