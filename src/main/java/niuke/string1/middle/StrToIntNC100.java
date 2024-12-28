package niuke.string1.middle;

/**
 * @Author pudding
 * @Date 2023/11/24 16:54
 */
public class StrToIntNC100 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型
     */
    public static int StrToInt(String s) {
        // write code here
        if (s.isEmpty())
            return 0;
        int res = 0;
        int index = 0;
        int n = s.length();
        //去掉前导空格，如果有
        while (index < n) {
            if (s.charAt(index) == ' ')
                index++;
            else
                break;
        }
        //去掉空格就什么都没有了
        if (index == n)
            return 0;
        int sign = 1;
        //处理第一个符号是正负号的情况
        if (s.charAt(index) == '+')
            index++;
        else if (s.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        //去掉符号就什么都没有了
        if (index == n)
            return 0;
        while (index < n) {
            char c = s.charAt(index);
            //后续非法字符，截断
            if (c < '0' || c > '9')
                break;
//            System.out.println(res);
            //处理越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 &&
                    (c - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 &&
                    (c - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }

    /**
     * 做法去掉前后的空格用trim方法
     * 判断第一个字符是正还是负 把索引后移加一 sign标志符号位变为-1 如果是其他字母不变
     * 开始循环遍历字符串 如果不是数字 直接结束
     * @param s
     * @return
     */
    public static int StrToInt1(String s) {
        String s1 = s.trim();
        int res = 0;
        if (s1.isEmpty()) return 0;
        int sign = 1;
        int index = 0;
        if (s1.charAt(index) == '+') {
            index++;
        } else if (s1.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        while (index < s1.length()) {
            char c = s1.charAt(index);
            if (c < '0' || c > '9')
                break;
            //处理越界大  如果结果大于整形最大值 或者等于
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 &&
                    (c - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
//            处理越界小
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 &&
                    (c - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int i = StrToInt("2147483647");
        int i = StrToInt1("2147483648 ");
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);


    }
}
