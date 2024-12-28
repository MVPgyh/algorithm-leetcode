package org.numbers.middle;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午8:58
 */
//字符串转整数
public class MyAtoi {
    public static void main(String[] args) {

    }
    public static int myAtoi(String s) {
        int len=s.length();
        char[] charArray = s.toCharArray();
        int index=0;
        //统计前导空格数
        if (index < len && charArray[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }
        int sign=1;
        char firstChar=charArray[index];
        if (firstChar == '+') {
            index++;
        }

        return 1;

    }
}
