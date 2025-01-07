package org.zifuString.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/7 下午10:36
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> pTos = new HashMap<>();
        HashMap<String, Character> sTop = new HashMap<>();
        String[] sArr = s.split("\\s+");
        char[] charArray = pattern.toCharArray();
        int plen=charArray.length,slen=sArr.length;
        if (plen!=slen)return false;
        for (int i = 0; i < plen; i++) {
            char c1 = charArray[i];
            String s1 = sArr[i];
            if (!pTos.containsKey(c1)) {
                pTos.put(c1,s1);
            }else {
                if (!pTos.get(c1).equals(s1)) {
                    return false;
                }
            }

            if (!sTop.containsKey(s1)) {
                sTop.put(s1, c1);
            }else {
                if (!sTop.get(s1).equals(c1)) {
                    return false;
                }
            }
            if (!pTos.get(c1).equals(s1)&&!sTop.get(s1).equals(c1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       String pattern = "abba", s = "dog cat cat dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }
}
