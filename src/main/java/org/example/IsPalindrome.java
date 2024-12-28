package org.example;



import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class IsPalindrome {
    //转换为字符串
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String x1=String.valueOf(x);
        String sb = new StringBuffer(x1).reverse().toString();
        return  sb.equals(x1);
    }
    //为了防止反转后的数字溢出 使用这个算法  求一半
    public static boolean isPalindrome1(int x) {
        if (x<0||(x%10==0&&x!=0)) return false;
        int revertedNumber=0;
        while (x > revertedNumber) {
            revertedNumber=revertedNumber*10+x%10;
            x/=10;
        }
        return x==revertedNumber || x==revertedNumber/10;

    }
    //绝佳算法  不用考虑数字溢出 纯数学算法
    // 一个数除以10 得到除个位数字的数字，一个数余10 求的出个位数字
    //余上对应位的数字，则求出对应位以后的数字
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;

    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(1121);
        System.out.println(palindrome);


    }
}