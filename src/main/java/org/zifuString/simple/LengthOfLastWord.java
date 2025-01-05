package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午10:45
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] split = s.split("\\s+");
        return split[split.length - 1].length();
    }

    public int lengthOfLastWord1(String s) {
        int index=s.length()-1;
        int count=0;
        for (int i = index; i >=0 ; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count >= 1) {
                break;
            }
        }
        return count;
    }
}
