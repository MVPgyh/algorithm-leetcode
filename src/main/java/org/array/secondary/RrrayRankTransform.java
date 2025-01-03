package org.array.secondary;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/3 下午10:05
 */
public class RrrayRankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        int[] temp = new int[arr.length];
        System.arraycopy(arr,0,temp,0,arr.length);
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        /*存到map中，键为数组的每个值，值为出现的次数*/
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i],map.size()+1);
            }
        }
        System.out.println(map);

        for (int i = 0; i < arr.length; i++) {
            Integer curr = map.get(arr[i]);
            res[i]=curr;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr={40,10,20,30};
        int[] ints = arrayRankTransform(arr);
        System.out.println(Arrays.toString(ints));
    }
}
