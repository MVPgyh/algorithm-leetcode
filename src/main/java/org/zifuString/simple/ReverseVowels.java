package org.zifuString.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午6:27
 */
public class ReverseVowels {
    /*双指针*/
    public String reverseVowels(String s) {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] charArray = s.toCharArray();
        int left=0,right=s.length()-1;
        while (left <= right) {
            if (list.contains(s.charAt(left)) && list.contains(s.charAt(right))) {
                char temp=charArray[left];
                charArray[left]=charArray[right];
                charArray[right]=temp;
                left++;right--;
            }else {
                if (!list.contains(s.charAt(left))) {
                    left++;
                }
                if (!list.contains(s.charAt(right))) {
                    right--;
                }
            }

        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("leetcode"));
    }
}
