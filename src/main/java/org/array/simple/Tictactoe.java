package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/4 下午11:06
 */
public class Tictactoe {
    public static void main(String[] args) {

    }

    /*枚举出所有获胜的情况，包括三横三竖和两对角，把赢得转化为9位的二进制，在转换为10进制
     * 分别是7 56 448 73 146 292 273 84*/
    public String tictactoe(int[][] moves) {
        int a = 0, b = 0, len = moves.length;
//       所有可能获胜的情况case
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
        for (int i = 0; i < len; i++) {
            /*通过 与&判断是否为奇数或偶数 如果与为1则为奇数*/
            if ((i & 1) == 1) {
                b ^= 1 << (3 * moves[i][0] + moves[i][1]);
            } else {
                a ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }
        }
        for (int i : ac) {
            if ((a & i) == i) {
                return "A";
            }
            if ((b & i) == i) {
                return "B" ;
            }
        }
        return len==9?"Draw":"Pending";

    }

    public String tictactoe1(int[][] moves) {
        int length = moves.length;
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
        int a=0,b=0;
        for (int i = 0; i < length; i++) {
            /*说明是奇数*/
            if ((i & 1) == 1) {
                a^=1<<(3*moves[i][0]+moves[i][1]);
            }else {
                b^=1<<(3*moves[i][0]+moves[i][1]);
            }
        }
        for (int i : ac) {
            if ((a & i) == i) {
                return "A";
            }
            if ((b & i) == i) {
                return "A";
            }
        }
        return length==9?"Draw":"Pending";
    }
}
