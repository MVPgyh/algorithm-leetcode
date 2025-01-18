package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午12:55
 */
/*1.排序法  2.单指针法两次循环第一个先把0 排到前面 第二次在排1 3、双指针*/
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int zero = 0;
        int two = len;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }


    /*双指针*/
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        /*遍历列表*/
        for (int i = 0; i < n; ++i) {
            /*等于1*/
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /*刷油漆方法*/
    public void sortColors2(int[] nums) {
        int n0=0,n1=0;
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            nums[i]=2;
            if (num < 2) {
                nums[n1++]=1;
            }
            if (num < 1) {
                nums[n0++]=0;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors2(new int[]{0,1,0,2});
    }
}
