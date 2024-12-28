package niuke.string1.simple;

/**
 * @Author pudding
 * @Date 2023/11/22 9:56
 */
public class PalindromeNC371 {


    public boolean palindrome(String str) {
//        核心思路   用双指针写  循环比较前后两个字符 如果 相等继续 左指针加 右指针减 在循环 不相等的话
//       删除一个字符
        // write code here
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                if (isValid(str.substring(l, r)) || isValid(str.substring(l + 1, r + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isValid(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
