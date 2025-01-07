package org.hashTable.simple;

import java.util.*;

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

    public boolean wordPattern1(String pattern, String s) {
        /*把s空格分隔转换为一个list*/
        List<String> ls = Arrays.asList(s.split("\\s+"));
        /*如果个数不相同 直接返回false*/
        int n = pattern.length();
        if (n != ls.size()) return false;

        /*遍历pattern 如果当前char得索引不等于 当前字符串对应得索引 直接返回false*/
        for (int i = 0; i < n; i++) {
            if (pattern.indexOf(pattern.charAt(i)) != ls.indexOf(ls.get(i)))
                return false;
        }
        return true;
    }

    /*双map法*/
    public boolean wordPattern2(String pattern, String s) {
        String[] strings = s.split("\\s+");
        if (pattern.length() != strings.length) return false;
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strings[i];
            if (!pMap.containsKey(c)) {
                pMap.put(c, str);
            }
            if (!sMap.containsKey(str)) {
                sMap.put(str, c);
            }
            if (!pMap.get(c).equals(str) || sMap.get(str) != c) {
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
