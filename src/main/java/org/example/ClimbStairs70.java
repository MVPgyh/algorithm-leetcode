package org.example;

/*动态规划问题*/
//TODO 动态规划
//条件是n大于1的
public class ClimbStairs70 {
    //递归会超时的  加一个方法存储每次递归的值  可以对其进行备忘录memo存储数字  时间复杂度由
    //2**n变为 n
    public static int climbStairs(int n) {
        if (n == 1) {
            return  1;
        }
        if (n == 2) {
            return  2;
        }
        int i = climbStairs(n - 1) + climbStairs(n - 2);
        return i;
    }

    //动态规划
    public static int climbStairs1(int n) {
        if (n == 1) {
            return  1;
        }
        //创建一个大小为n+1的数组 记录每一阶台阶有几种方法
        int [] dp=new int[n+1];
        //第一台阶有一个，第二台阶有两个
        dp[1]=1;
        dp[2]=2;
        //从第三个台阶开始 个数等于下台阶和下下台阶的和
        for (int i = 3; i <n+1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return  dp[n];
    }
    /*方法三 通项公式*/
    /*齐次线性递推 具体看力扣官网第70题解析*/


    public static void main(String[] args) {
        int i = climbStairs(5);
        System.out.println(i);
        int i1 = climbStairs1(3);
        System.out.println(i1);
    }
}
