package org.math;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/30 下午9:05
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(66, 3));
    }

    public static int divide(int dividend, int divisor) {
        /*如果被除数是最小值，除数是-1 则返回最大值*/
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return  Integer.MAX_VALUE;
        }
        /*求被除数和除数绝对值*/
        long a=Math.abs((long) dividend),b=Math.abs((long) divisor);
        int res=0;
        for (int i = 31; i >=0; i--) {
            if ((a >> i) >= b) {
                res+=1<<i;
                a-=b<<i;
            }

        }
        /*如果符号相同 返回正数，不同返回负数*/
//        return (dividend>0) ==(divisor>0)?res:-res;
        return (dividend^divisor)>0?res:-res;
    }
}
