package org.zifuString.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午11:49
 */
public class IntToRoman {
    public static void main(String[] args) {
        String s = intToRoman1(0);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }


    public static String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer buffer=new StringBuffer();
        int len=values.length;
        for (int i = 0; i < len; i++) {
            int value=values[i];
            String symbol = symbols[i];
            while (values[i] <= num) {
                num-=value;
                buffer.append(symbol);
            }
        }


        return buffer.toString();

    }
}
