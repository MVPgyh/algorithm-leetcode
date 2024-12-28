package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午10:59
 */
public class MaxAreaWater {
    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
    /*//暴力循环大法
    public static int maxArea(int[] height) {
        int len=height.length;
        if (len<2) return 0;
        int maxWater=0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int min = Math.min(height[i], height[j]);
                maxWater=Math.max(maxWater,(j-i)*min);
            }
        }
        return maxWater;
    }*/

    public static int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) return 0;
        int left = 0, right = 1;
        int maxCapacity = 0;
        while (left != right&&left!=len-1) {
            int minHeight = Math.min(height[left], height[right]);
            maxCapacity = Math.max(maxCapacity, (right - left) * minHeight);
            if (right == len - 1) {
                left++;
                right=left+1;
            }else {
                right++;
            }

        }
        return maxCapacity;
    }
}
