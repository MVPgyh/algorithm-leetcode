package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午9:03
 */
public class IsFlipedString {
    public static void main(String[] args) {

    }
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        String s=s2+s2;
        return s.contains(s1);
    }
}
