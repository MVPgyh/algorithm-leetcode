package org.zifuString.secondary;

/**
 * @Author pudding
 * @Date 2023/11/21 14:30
 */
public class NewLongestString2745 {

    //    输入：x = 2, y = 5, z = 1
//输出：12
//解释： 我们可以按顺序连接 "BB" ，"AA" ，"BB" ，"AA" ，"BB" 和 "AB" ，得到新字符串 "BBAABBAABBAB"
    static int test(int x, int y, int z) {
        int min = Math.min(x, y);
        if (x == y) {
            return 2*(x+y+z);
        }
        return min*2+(min+1)*2+2*z;

    }

    public static void main(String[] args) {
        System.out.println(test(3, 2, 2));
    }
}
