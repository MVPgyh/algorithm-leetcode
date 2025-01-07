package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/7 下午9:25
 */
public class CountKeyChanges {
    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC"));
    }
    public static int countKeyChanges(String s) {
        int sum=0,len=s.length();
        for (int i = 1; i < len; i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);
            int abs = Math.abs(cur - pre);
            if ( abs!= 32&&abs!=0) {
                sum++;
            }
        }
        return sum;
    }
}
