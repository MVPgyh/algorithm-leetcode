package org.zifuString.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/25 下午11:12
 */
public class NoRepeatStr {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(rightAnswerMy(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.trim().length() == 0 || s.length()==1) {
            return 1;
        }
        int max=0;
        int left=0,index=0;
        StringBuilder temp= new StringBuilder();

        while (left != s.length()) {
            /*如果无重复的字符 则temp加上*/
            if (!temp.toString().contains(String.valueOf(s.charAt(left)))) {
                temp.append(s.charAt(left));
                if (index == 0 && left == s.length() - 1) {
                    return s.length();
                }
                left++;

                continue;
            }
            max=Math.max(max,left-index);
            left=(++index);
            temp.delete(0,temp.length());
        }
        max=Math.max(max,left-index);
        return max;
    }

    public int rightAnswer(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int rightAnswerMy(String s) {
        int max=0,left=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && left<=map.get(s.charAt(i))) {
                left=map.get(s.charAt(i))+1;

            }
            map.put(s.charAt(i),i);
            max=Math.max(i-left+1,max);
        }
        return  max;
    }




}
