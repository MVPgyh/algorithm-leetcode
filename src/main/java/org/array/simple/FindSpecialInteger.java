package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 上午12:22
 */
public class FindSpecialInteger {
    public static int findSpecialInteger(int[] arr) {
        int len = arr.length, left = 0, right = 0;
        while (right < len) {
            if (arr[left] == arr[right]) {
                if ((right - left + 1) * 4 > len) {
                    return arr[left];
                }
                right++;
            } else {
                left = right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,6,6,6,6,7,10};
        int specialInteger = findSpecialInteger(arr);
        System.out.println(specialInteger);
    }
}
