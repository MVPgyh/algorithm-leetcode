package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/21 下午9:36
 */
public class NumberOfBeams {
    /*银行中的激光束数量 2125*/
    public int numberOfBeams(String[] bank) {
        int col = bank[0].length(),row = bank.length,res=0;
        int preSum=0,curSum=0;
        for (int i = 0; i < row; i++) {
            char[] curRow = bank[i].toCharArray();
            for (int j = 0; j < col; j++) {
                if (curRow[j]=='1'){
                    curSum++;
                }
            }
            if (curSum == 0) {
                continue;
            }
            int sums = preSum * curSum;
            preSum=curSum;
            curSum=0;
            res+=sums;
        }
        return  res;
    }

    public static void main(String[] args) {
        NumberOfBeams numberOfBeams = new NumberOfBeams();
        System.out.println(numberOfBeams.numberOfBeams(new String[]{"011001","000000","010100","001000"}));
    }
}
