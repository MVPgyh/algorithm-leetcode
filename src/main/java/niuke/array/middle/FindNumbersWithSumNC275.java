package niuke.array.middle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author pudding
 * @Date 2023/11/25 21:43
 */
public class FindNumbersWithSumNC275 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (hm.containsKey(array[i])) {
                Integer integer = hm.get(array[i]);
                arrayList.add(integer);
                arrayList.add(array[i]);
                return  arrayList;
            }
            hm.put(sum-array[i],array[i]);

        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] a={1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(a, 15));
    }
}
