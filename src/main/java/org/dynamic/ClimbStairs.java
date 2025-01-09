package org.dynamic;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/9 下午10:43
 */
public class ClimbStairs {

    /*递归记录 会超时*/
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /*用数组记录 不重复计算相同楼梯方式数量*/
    public int climbStairs1(int n) {
        if (n==1)return 1;
        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[n];
    }

    /*动态规划  滚动数组*/
    public int climbStairs2(int n) {
        int p=0,q=0,r=1;
        for (int i = 1; i <=n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }


    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(9));
    }
}
