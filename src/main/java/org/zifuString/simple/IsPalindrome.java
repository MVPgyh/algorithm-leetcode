package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午10:05
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while (left <= right) {
            /*这里if换成while更好*/
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        int n=s.length();
        int left=0,right=n-1;
        /*前闭后开区间 只是寻找 左右俩指针指向的元素是否相等*/
        /*如果要用等号 下面的if也要用等号*/
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return  false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("0P"));
    }
}
