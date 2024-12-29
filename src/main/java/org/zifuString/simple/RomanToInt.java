package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 上午12:34
 */
public class RomanToInt {
    public static void main(String[] args) {
        /*1994*/
        int i = romanToInt1("MCM");
        System.out.println(i);

    }
    /*条件就是 前一个数比第二个数小*/
    public int romanToInt(String s) {
        int sum=0;
        int preValue = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(preValue < num) {
                sum -= preValue;
            } else {
                sum += preValue;
            }
            preValue = num;
        }
        sum+=preValue;
        return sum;

    }
    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int romanToInt1(String s) {
        int sum=0;
        int preValue = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(preValue < num) {
                sum -= preValue;
            } else {
                sum += preValue;
            }
            preValue = num;
        }
        sum+=preValue;
        return sum;
    }
    private static int getValue1(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
