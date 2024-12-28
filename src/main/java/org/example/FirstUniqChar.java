package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//字符串中的第一个唯一字符

public class FirstUniqChar {
    //自己做的

    /**
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new LinkedHashMap<>();
        char[] schar = s.toCharArray();
        System.out.println(schar);
        for (int i = 0; i < schar.length; i++) {
            if (hm.containsKey(schar[i])) {
                Integer in = hm.get(schar[i]);
                in += 1;
                hm.put(schar[i], in);
                continue;
            }
            hm.put(schar[i], 1);
        }
        if (hm.containsValue(1)) {
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                if (entry.getValue().equals(1)) {
                    Character key = entry.getKey();
                    int index = s.indexOf(key);
                    return index;
                }
            }
        }
        return -1;
    }

    /**
     * 在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。
     * 在第二次遍历时，我们只要遍历到了一个只出现一次的字符，那么就返回它的索引，
     * 否则在遍历结束后返回 −1-1−1。
     */
    public static int firstUniqCharLeetCode(String s) {
        //创建哈希map
        HashMap<Character, Integer> hm = new HashMap<>();
        //循环字符串s的每个字符
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //把字符添加到hmmap中，如果没有对应的键 返回默认值0
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        //再次从头开始循环遍历字符串中的每一个字符 如果字符在hmmap的值为一 就返回其值，没有的话返回-1 查询不到
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("love"));
    }
}
