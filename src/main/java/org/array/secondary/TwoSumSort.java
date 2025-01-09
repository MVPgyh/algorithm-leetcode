package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/9 下午11:51
 */
public class TwoSumSort {
    /*二分查找法 一个指向头 一个指向尾巴*/
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid=(high-low)/2+low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i+1,mid+1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high=mid+1;
                }else {
                    low=mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSumSort sort = new TwoSumSort();
        int[] ints = sort.twoSum(new int[]{3, 24, 50, 79, 88, 150, 345},200);
        System.out.println(ints);

    }
}
