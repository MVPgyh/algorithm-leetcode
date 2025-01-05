package org.recursion;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午2:41
 */
public class KthCharacter {
    public static char kthCharacter(int k) {
        StringBuffer buffer = new StringBuffer("a");
        while (buffer.length() <= k) {
            int len = buffer.length();
            for (int i = 0; i < len; i++) {
                buffer.append((char) (buffer.charAt(i) +1));
            }
        }
        return buffer.charAt(k-1);
    }

    public static void main(String[] args) {
        char c = kthCharacter(10);
        System.out.println(c);
    }

}
