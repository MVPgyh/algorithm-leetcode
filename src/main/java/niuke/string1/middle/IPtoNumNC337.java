package niuke.string1.middle;

import java.math.BigInteger;

/**
 * @Author pudding
 * @Date 2023/11/26 13:49
 */
public class IPtoNumNC337 {
    public static String IPtoNum (String ip) {
        // write code here
        String[] split = ip.split("\\.");
        String join = String.join("", split);
        System.out.println(join);
        Long aLong = Long.valueOf(join);
        String s = Long.toString(aLong, 2);

      return   Long.valueOf(s,2).toString();
    }

    public static void main(String[] args) {
        System.out.println(IPtoNum("114.55.207.244"));
        System.out.println(1<<24);

    }
}
