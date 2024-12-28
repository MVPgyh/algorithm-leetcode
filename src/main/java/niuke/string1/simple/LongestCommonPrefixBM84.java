package niuke.string1.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @Date 2023/11/21 19:40
 */
public class LongestCommonPrefixBM84 {
    public static String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0||strs ==null) return "";
        int rows = strs.length;
        int cols = strs[0].length();
        for (int i = 0; i < cols; i++) {
            char firstChar = strs[0].charAt(i);
            for (int j = 0; j < rows; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != firstChar) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {

    }
}
