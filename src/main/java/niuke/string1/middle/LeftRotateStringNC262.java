package niuke.string1.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author pudding
 * @Date 2023/11/26 13:15
 */
public class LeftRotateStringNC262 {
    public static String LeftRotateString (String str, int n) {
        if (str.length()==0) return "";
        // write code here
        char[] charArray = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char header = charArray[0];
            for (int j = 0; j < charArray.length; j++) {
                if (j == charArray.length - 1) {
                    charArray[j]=header;
                    break;
                }
                charArray[j]=charArray[j+1];
            }
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("aab", 10));
    }
}
