package niuke.string1.middle;

import java.math.BigInteger;

/**
 * @Author pudding
 * @Date 2023/11/21 21:15
 */
public class BigNumberSumBM86 {

    public static String solve(String s, String t) {
        int slen = s.length() - 1,tlen=t.length()-1;
        int carry=0;
        StringBuilder stringBuilder = new StringBuilder();
        while (slen >= 0 || tlen >= 0 || carry > 0) {
            int snum=slen>=0?s.charAt(slen)-'0':0;
            int tnum=tlen>=0?t.charAt(tlen)-'0':0;
            int num=(snum+tnum+carry)%10;
            carry=(snum+tnum+carry)/10;
            stringBuilder.append(num);
            slen--;
            tlen--;
        }
        return  stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(solve("545", ""));

    }
}
