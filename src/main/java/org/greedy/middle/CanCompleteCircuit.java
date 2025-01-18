package org.greedy.middle;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午8:08
 */
/*134. 加油站 贪心*/
public class CanCompleteCircuit {
    /*超时了  学到了取余解决+1循环问题*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            /*可以出发的起始点*/
            int surOil = gas[i];
            int point = i;
            while (surOil >= cost[point]) {
                /*用取余可以解决终点到起点的问题*/
                surOil = surOil - cost[point] + gas[point + 1 % len];
                /*这里可以优化 用取余符号 */
               /* if (point == len - 1) {
                    point = 0;
                    surOil = surOil - costPoint + gas[point];
                } else {
                    surOil = surOil - costPoint + gas[point + 1];
                    point++;
                }*/
                point = (point + 1 % len);
                if (point == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*官方解法 贪心*/
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumofGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumofGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumofGas) {
                    break;
                }
                cnt++;

            }
            /*说明从当前起始点出发无法完成旅程。此时，将起始点更新为i + cnt + 1，即跳过当前
            已经考虑过的所有加油站，从下一个未考虑的加油站开始作为新的起始点。注意这里的+1是为了
            确保不会重复考虑同一个加油站作为起始点（在cnt为n-1时，如果不加+1，则下一个起始点会是起始点本身，形成无限循环）*/
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    /*最快的方法*/
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int ans = 0;
        int minS = 0;
        int s = 0;
        for (int i = 0; i < gas.length; i++) {
            /**/
            s += gas[i] - cost[i];
            if (s < minS) {
                minS = s;
                ans = i + 1;
            }
        }
        return s < 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] gas = {5, 8, 2, 8};
        int[] cost = {6, 5, 6, 6};
        CanCompleteCircuit circuit = new CanCompleteCircuit();
        System.out.println(circuit.canCompleteCircuit(gas, cost));
    }
}
