package niuke.string1.simple;

import java.util.HashMap;

/**
 * @Author pudding
 * @Date 2023/11/24 19:16
 */
public class CompressStringNC101 {
    public static String compressString(String param) {
        // write code here

        if (param.length() <= 1) {
            return param;
        }
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            if (param.charAt(left) == param.charAt(right)) {
                right++;
            } else {
                sb.append(param.charAt(left));
                if (right - left != 1) {
                    sb.append(right - left);
                }
                left = right;
                right++;
            }
        }
        sb.append(param.charAt(left));
        if (right - left != 1) {
            sb.append(right-left);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(compressString("aabcccccaaa"));
    }
}
