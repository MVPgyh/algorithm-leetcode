package org.zifuString.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/28 下午5:03
 */
public class convertZString {
    public static void main(String[] args) {
        String s = convertZString("PAYPALISHIRING", 4);
        System.out.println(s);
    }

    public static String convertZString(String s, int numRows) {
        int len=s.length();
        if (numRows == 1 || len < numRows ) {
            return  s;
        }
        int colNums= ((len+(2*numRows-2)-1)/(2*numRows-2))*(numRows-1);
        char[] charArray = s.toCharArray();
        char[][] chars = new char[numRows][colNums];
        for (int i = 0, x = 0, y = 0; i < len; i++) {
            if (i % (2 * numRows - 2) < numRows - 1) {
                chars[x][y]=charArray[i];
                x++;
            }else {
                chars[x][y]=charArray[i];
                x--;
                y++;
            }
        }
        StringBuilder result= new StringBuilder();
        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (c != 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();

    }


}
