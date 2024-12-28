package org.array.simple;

/*双指针解法*/
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int left=0,right=0;
        while (right < len) {
            if (nums[right] != val) {
                nums[left]=nums[right];
                right++;
                left++;
                continue;
            }
            right++;
        }
        return  left;
    }

    public int removeElement1(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        int len = nums.length;
        while(fast<len){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
