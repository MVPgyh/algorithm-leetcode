package org.zifuString.simple;

import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 上午12:55
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] sArray={"abc","bcd","wda"};
        String s = longestCommonPrefix(sArray);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
