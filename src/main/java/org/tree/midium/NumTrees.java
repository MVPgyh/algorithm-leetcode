package org.tree.midium;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午4:50
 */
/*不同的二叉搜索树 动态规划（n个节点的不同二叉搜索树个数）*/
public class NumTrees {
    /*动态规划*/
    /*dp[i] = i个不同的数组成的二叉搜索数的个数
        假设 i = 5
        当根节点等于 1 时 ，其余数字都比1大，只能在右边 dp[i] += dp[4]
        当根节点等于 2 时，左边有一个1比2小，右边有三个比2大的数字 dp[i] += dp[1] * dp[3]
        当根节点等于 3 时，左边有两个数比3小，右边有两个数比3大的数字 dp[i] += dp[2] * dp[2]
        ...
        知道根节点等于5，左边有4个数字比5小，只能放在5的左边,dp[i] += dp[4]


        */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /*数学 卡特兰数*/
    public int numTrees1(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    public int numTrees2(int n) {
        int[] ints = new int[n + 1];
        ints[0]=1;
        ints[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ints[i]+=ints[j-1]*ints[i-j];
            }
        }
        return ints[n];
    }
}
