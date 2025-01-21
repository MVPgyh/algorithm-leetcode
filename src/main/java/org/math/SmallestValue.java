package org.math;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/20 下午10:26
 */

/*2507. 使用质因数之和替换后可以取到的最小值*/
public class SmallestValue {
    public int smallestValue(int n) {
        int result = n;
        while (true) {
            int x = n;
            int i = 2;
            int s = 0;
            while (i * i <= x) {
                while (x % i == 0) {
                    s += i;
                    x /= i;
                }
                i++;
            }
            if (x > 1) {
                s += x;
            }
            if (s == n) {
                return n;
            }
            n = s;
        }
    }

    /*递归方法*/
    public int smallestValue1(int n) {
        int ans = 0, tmp = n;
        /*从2开始取余数字 每次加一  如果取余等于0 说明不是素数*/
        for (int i = 2; tmp > 1; i++) {
            while (tmp % i == 0) {
                tmp /= i;
                ans += i;
            }
        }
        return ans == n ? n : smallestValue(ans);
    }

    public static void main(String[] args) {
        SmallestValue smallestValue = new SmallestValue();
        System.out.println(smallestValue.smallestValue(15));
    }

}
