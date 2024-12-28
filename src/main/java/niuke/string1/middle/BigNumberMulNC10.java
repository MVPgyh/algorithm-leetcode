package niuke.string1.middle;

import java.math.BigInteger;

/**
 * @Author pudding
 * @Date 2023/11/22 10:52
 */
public class BigNumberMulNC10 {

//    大数相乘
    public static String solve(String s, String t) {

//        将两个字符串中每个数组中分别存放在整形数组中
        int slen = s.length(), tlen = t.length();
        int[] sarr = new int[slen];
        int[] tarr = new int[tlen];
        for (int i = 0; i < slen; i++) {
            sarr[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < tlen; i++) {
            tarr[i] = t.charAt(i) - '0';
        }
//        存放结果
        int[] res = new int[slen + tlen];
        for (int i = 0; i < slen; i++) {
            for (int j = 0; j < tlen; j++) {
                res[i + j + 1] += sarr[i] * tarr[j];
            }
        }
        int carry = 0;
        for (int i = slen + tlen - 1; i >= 0; i--) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] = res[i] % 10;
        }
        StringBuilder ans = new StringBuilder();
        int cur = 0;
        while (cur < slen + tlen && res[cur] == 0) {
            cur++;
        }
        for (int i = 0; i < res.length; i++) {
            ans.append(res[i]);
        }
        return ans.length()==0?"0":ans.toString();

    }

    public static void main(String[] args) {
        System.out.println(solve("82", "32"));

    }

}
