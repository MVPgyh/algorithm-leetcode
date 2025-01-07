package org.hashTable.medium;

import java.util.LinkedHashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/7 下午11:40
 */
public class GetHint {
    public static String getHint(String secret, String guess) {
        int len = secret.length();
        int bnum = 0;
        int anum = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(secret.charAt(i))) {
                map.put(secret.charAt(i), 1);
            } else {
                map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                anum++;
                map.put(gc, map.get(gc) - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if (sc == gc) {
                continue;
            }
            if (map.containsKey(gc) && map.get(gc) != 0) {
                bnum++;
                map.put(gc, map.get(gc) - 1);
            }
        }
        return anum+"A"+bnum+"B";

    }

    public static void main(String[] args) {
        System.out.println(getHint("1122", "1222"));
    }
}
