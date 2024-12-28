package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/27 上午12:18
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int L = 1; L < s.length(); L++) {
            for (int i = 0; i < L; i++) {
                if (charArray[i] != charArray[L]) {
                    dp[i][L] = false;
                } else {
                    if (L - i < 2) {
                        dp[i][L] = true;
                    } else {
                        dp[i][L] = dp[i + 1][L - 1];
                    }
                }
                if (dp[i][L] && L - i + 1 > maxLen) {
                    maxLen=L-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }
}
