package org.array.secondary;

import java.util.ArrayList;
import java.util.Random;

/*o1时间插入 删除 和获取随机元素 自己写的*/
class RandomizedSet {

    private ArrayList<Integer> arrayList;

    public RandomizedSet() {
        this.arrayList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (arrayList.contains(val)) {
            return false;
        } else {
            arrayList.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!arrayList.contains(val)) {
            return false;
        } else {
            arrayList.remove(Integer.valueOf(val));
            return true;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int randomint = random.nextInt(arrayList.size());
       return arrayList.get(randomint);
    }
}