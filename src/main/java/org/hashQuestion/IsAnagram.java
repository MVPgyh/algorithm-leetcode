package org.hashQuestion;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/12 下午10:05
 */
/*有效的字母异位词*/
public class IsAnagram {
    /*哈希表*/
    public boolean isAnagram(String s, String t) {
        int len1=s.length(),len2=t.length();
        if (len1!=len2) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            char cur = t.charAt(i);
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        for (int i = 0; i < len1; i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur) || map.get(cur) == 0) {
                return false;
            }else {
                map.replace(cur,map.get(cur)-1);
            }
        }
        return true;
    }
    /*排序 判断是否相等*/
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /*用数组替代哈希表*/
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            /*如果 当前char值小于0 return false*/
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    /*最快的方式*/
    public boolean isAnagram4(String s, String t){
        int[] map=new int[123];
        int len1=s.length();
        int len2=t.length();
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        if(len1!=len2){
            return false;
        }
        for(char ch:s1){
            map[ch]++;
        }
        for(char ch:t1){
            map[ch]--;
        }
        for(int i=0;i<123;i++){
            if(map[i]!=0){
                return false;
            }
        }
        return true;
    }


}
