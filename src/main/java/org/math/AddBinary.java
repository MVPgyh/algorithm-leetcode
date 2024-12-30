package org.math;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/30 下午11:07
 */
public class AddBinary {
    public static void main(String[] args) {
        addBinary("11", "1");
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            res.append(carry % 2);
            carry/=2;
        }
        return res.reverse().toString();
    }
}
