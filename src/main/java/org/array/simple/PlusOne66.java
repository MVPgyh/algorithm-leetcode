package org.array.simple;

import java.math.BigInteger;
import java.util.Arrays;
/*把数组转化为数字 并把数字转化为数组*/
public class PlusOne66 {
    //本币解法 转成字符串解题失败  超出int的最大值 报错
    public static int[] plusOne(int[] digits) {
        if (digits[0]==0) return new int[]{1};
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < digits.length; i++) {
            st.append(digits[i]);
        }
        String s = st.toString();
        int it = Integer.parseInt(s)+1;
        String s1 = String.valueOf(it);
        int anslen = s1.length();
        int[] ans = new int[anslen];
        for (int i = 0; i < anslen; i++) {
            char c = s1.charAt(i);
            ans[i]=c-'0';
            System.out.println(ans[i]);
        }

        return ans;
    }

    public int[] plusone1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        //如果所有位都是进位，则长度+1
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static int[] plusone2(int[] digits) {
        int len=digits.length;
        for (int i = len-1; i >=0 ; i--) {
            if (digits[i] == 9) {
                digits[i]=0;
            }else {
                digits[i]+=1;
                return  digits;
            }
        }
        int[] ans = new int[len + 1];
        ans[0]=1;
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusone2(new int[]{1, 2, 9})));

    }
}
