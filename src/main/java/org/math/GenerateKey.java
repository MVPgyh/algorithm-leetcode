package org.math;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/11 上午10:59
 */
/*纯数学题*/
public class GenerateKey {
    public int generateKey(int num1, int num2, int num3) {
        int key=0;
        /*这里p*=10 个位为1，十位为10，百位为100 才可以得到最后的res*/
        for (int p = 1; num1 > 0 && num2 > 0 && num3 > 0; p*=10) {
            /*从低位比较 三个数的最小值 并加入到结果中*/
            key += Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10)*p;
            /*获取每个数上一位的值*/
            num1/=10;
            num2/=10;
            num3/=10;
        }
        return key;
    }

    public static void main(String[] args) {
        System.out.println(0/10);
    }
}
