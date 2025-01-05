package org.recursion;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/5 下午2:02
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
//        用递归，如果n是3的幂次方，则n/3也是3的幂次方。。。
        if (n==1) return true;
        if (n==0) return false;
        return n%3==0?isPowerOfThree(n/3):false;
    }
}
