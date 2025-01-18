package org.array.secondary;

import java.util.HashMap;
import java.util.Random;


/*哈希表+删除交换  哈希表来实现o1的复杂度*/
class RandomizedSet1 {

    private HashMap<Integer, Integer> map;
    private Random random;
    private int[] arrs = new int[200010];
    private int index = -1;

    public RandomizedSet1() {
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arrs[++index] = val;
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        /*覆盖思想 如果刚好等于 index*/
        if (loc != index) {
            map.put(arrs[index], loc);
        }
        arrs[loc] = arrs[index--];
        return true;
    }

    public int getRandom() {
        return arrs[random.nextInt(index + 1)];
    }

    public static void main(String[] args) {
        RandomizedSet1 randomizedSet1 = new RandomizedSet1();
        randomizedSet1.insert(1);
        randomizedSet1.insert(2);
        randomizedSet1.insert(3);
        randomizedSet1.remove(1);
        randomizedSet1.remove(2);
    }
}