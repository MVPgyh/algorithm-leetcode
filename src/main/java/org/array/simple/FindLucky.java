package org.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/3 下午10:34
 */
public class FindLucky {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
    /*使用哈希映射 把数值作为键，出现次数作为值*/
    public static int findLucky(int[] arr) {
        int res=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key.equals(value)) {
              res=  Math.max(res,key);
            }
        }
        return res;
    }

    public static int findLucky1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int ans=-1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == value) {
                ans=Math.max(ans,key);
            }
        }
        return ans;
    }
}
