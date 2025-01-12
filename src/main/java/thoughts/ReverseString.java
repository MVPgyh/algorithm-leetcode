package thoughts;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午11:34
 */
/*双指针写法 反转字符串*/
/*单指针也可以 因为right+left=len-1 所以 right=len-left-1*/
public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length, left = 0, right = n - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public void reverseString1(char[] s) {
        int n = s.length, left = 0, right = n - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        r.reverseString(new char[]{'a', 'c', 'z', 's'});
    }
}
