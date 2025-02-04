package org.hashTable.medium;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/2/4 下午10:37
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        int len=strs.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if (map.containsKey(s)) {
                Integer index = map.get(s);
                res.get(index).add(str);
            }else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                res.add(strings);
                map.put(s,res.indexOf(strings));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={"a"};
        System.out.println(groupAnagrams(strs));
    }
}
