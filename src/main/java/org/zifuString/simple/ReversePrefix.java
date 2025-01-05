package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午6:20
 */
public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        StringBuffer buffer = new StringBuffer();
        if (i == -1) return word;
        for (int j = i; j >=0; j--) {
            buffer.append(word.charAt(j));
        }
        buffer.append(word.substring(i+1));
        return buffer.toString();
    }
}
