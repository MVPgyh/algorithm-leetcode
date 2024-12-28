package niuke.string1.simple;

import java.util.Arrays;

/**
 * @Author pudding
 * @Date 2023/11/21 18:42
 */
public class StringBM83 {

    public static  String reverse(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
           char s= Character.isLowerCase(str.charAt(i))? (Character.toUpperCase(str.charAt(i))): Character.toLowerCase (str.charAt(i));
           stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static String trans (String s, int n) {
//        spilt 的第二参数如果是正数 等于返回数组的长度 如果大于被分割的 则按最多分割的字符算
//        如果是负数  按照最多的 不会省略后面的空字符  如果是0舍弃
        String[] tmp = s.split(" ",-1);
        System.out.println(Arrays.toString(tmp));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tmp.length-1; i >= 0; i--) {
            stringBuilder.append(reverse(tmp[i]));
            if(i != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static String trans1(String s, int n) {
        // 本题实际就是把字符串s反转(单词中的字符位置不反转)，遇到空格不变，遇到大写字母变成小写，小写字母变成大写
        StringBuffer res = new StringBuffer(); // 存放最终结果
        int index = 0; // 记录字母应插入的位置
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                res.append(" ");
                index = res.length();
            } else {
                // 当前字符是字母
                if (ch >= 'A' && ch <= 'Z') {
                    res.insert(index, (char)(ch + 32)); // 大写字母变为小写，每次都插在index位置
                } else {
                    res.insert(index, (char)(ch - 32)); // 小写字母变为大写，每次都插在index位置
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(trans("This is a sample", 16));
    }
}
