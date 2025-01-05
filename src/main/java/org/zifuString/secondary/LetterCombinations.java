package org.zifuString.secondary;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午12:03
 */

/*深度优先搜索 dfs*/
//    三层循环
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int n = digits.length();
        if (n == 0){
            return result;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        result = map.get(digits.charAt(0));
        if (n == 1){
            return result;
        }
        int i = 1;
        /*从第一位开始遍历*/
        while (i < n){
            List<String> temp = new ArrayList<>();
            /*获取每位数字对应的几个字母并遍历*/
            for (String s1 : result) {
                /*获取第i位对应的字母 并且存储到 temp中*/
                for (String s2 : map.get(digits.charAt(i))) {
                    temp.add(s1+s2);
                }
            }
            result = temp;
            i++;
        }
        return result;
    }
    public List<String> letterCombinations1(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        /*建立哈希映射*/
        HashMap<Character, String> phoneMap = new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;


    }
    public  void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination){
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }else {
            char digit=digits.charAt(index);
            String letters=phoneMap.get(digits);
            int lettersCount=letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
