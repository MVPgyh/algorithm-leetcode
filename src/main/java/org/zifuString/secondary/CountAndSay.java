package org.zifuString.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午9:50
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str="1";
        for (int i = 2; i <= n; i++) {
            int pos=0,start=0;
            StringBuffer sb = new StringBuffer();
            /*获取当前数的最终字符串*/
            while (pos < str.length()) {
                /*start0pos0 开始 pos和start对应的值相等则pos加一，不相等则拼接数字对应的最终字符串*/
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(pos-start).append(str.charAt(start));
                start=pos;
            }
            str= sb.toString();
        }
        return str;

    }

    /*递归法*/
    public String countAndSay1(int n) {
        // 递归的结束条件
        if (n == 1){
            return "1";
        }
        // 递归，接受下一次的外观数列字符串结果
        String prev = countAndSay1(n-1);
        // 构建当前的的外观字符串
        StringBuilder sb = new StringBuilder();
        // 每个字符最少出现1次
        int count = 1;
        // 遍历上一轮的外观字符串，构造当前的外观字符串
        for (int i = 0; i < prev.length(); i++) {
            // 判断相邻的下一个字符与当前是否相等
            if (i+1<prev.length()&&prev.charAt(i) == prev.charAt(i+1)){  // 相等则+1
                count++;
            }else {    // 不相等则追加当前字符的次数和字符
                sb.append(count).append(prev.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }

}
