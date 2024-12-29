package org.zifuString.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午4:18
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }
    public static boolean isIsomorphic(String s, String t) {
        int len=s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            if ((map.containsKey(sCur)&&map.get(sCur)!=tCur) ) {
                return false;
            } else if (map.containsValue(tCur)) {
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    Character value = entry.getValue();
                    Character key = entry.getKey();
                    if (value==tCur&&key!=sCur) {
                        return false;
                    }
                }
            }
            map.put(sCur,tCur);
        }


        return true;
    }
}
