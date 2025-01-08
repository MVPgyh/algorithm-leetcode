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

    public String getHint1(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";


    }

    public static void main(String[] args) {
        System.out.println(getHint("1122", "1222"));
    }
}
