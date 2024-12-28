package niuke.string1.middle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author pudding
 * @Date 2023/11/21 20:08
 */
public class SolveIpBM85 {
    static final String IPv6 = "IPv6";
    static final String Neither = "Neither";
    static final String IPv4 = "IPv4";

    boolean isIPv4(String IP) {
        if (IP.indexOf('.') == -1) {
            return false;
        }
        String[] s = IP.split("\\.");
        //IPv4必定为4组
        if (s.length != 4)
            return false;
        for (int i = 0; i < s.length; i++) {
            //不可缺省，有一个分割为零，说明两个点相连
            if (s[i].length() == 0)
                return false;
            //比较数字位数及不为零时不能有前缀零
            if (s[i].length() < 0 || s[i].length() > 3 || (s[i].charAt(0) == '0' && s[i].length() != 1))
                return false;
            int num = 0;
            //遍历每个分割字符串，必须为数字
            for (int j = 0; j < s[i].length(); j++) {
                char c = s[i].charAt(j);
                if (c < '0' || c > '9')
                    return false;
                //转化为数字比较，0-255之间
                num = num * 10 + (c - '0');
                if (num < 0 || num > 255)
                    return false;
            }
        }
        return true;
    }

    boolean isIPv6(String IP) {
        if (IP.indexOf(':') == -1) {
            return false;
        }
        String[] s = IP.split(":", -1);
        //IPv6必定为8组
        if (s.length != 8) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            //每个分割不能缺省，不能超过4位
            if (s[i].length() == 0 || s[i].length() > 4) {
                return false;
            }
            for (int j = 0; j < s[i].length(); j++) {
                //不能出现a-fA-F以外的大小写字符
                char c = s[i].charAt(j);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
                if (!expr) {
                    return false;
                }
            }
        }
        return true;
    }

    String solve(String IP) {
        if (isIPv4(IP))
            return "IPv4";
        else if (isIPv6(IP))
            return "IPv6";
        return "Neither";
    }

    String solve1(String IP) {
        //正则表达式限制0-255 且没有前缀0 四组齐全
        String ipv4="(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern ipv4_pattern = Pattern.compile(ipv4);
        //正则表达式限制出现8组，0-9a-fA-F的数，个数必须是1-4个
        String ipv6="([0-9a-fA-F]{1,4}\\:){7}[0-9a-fA-F]{1,4}";
        Pattern ipv6_pattern = Pattern.compile(ipv6);
        //调用正则匹配函数
        if (ipv4_pattern.matcher(IP).matches())
            return "IPv4";
        else if (ipv6_pattern.matcher(IP).matches())
            return "IPv6";
        else return "Neither";
    }

    public static void main(String[] args) {




    }
}
