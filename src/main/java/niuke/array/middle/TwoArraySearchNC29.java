package niuke.array.middle;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @Author pudding
 * @Date 2023/11/22 15:32
 */
public class TwoArraySearchNC29 {
    public boolean Find (int target, int[][] array) {
        // write code here
        long count = Arrays.stream(array).filter((Predicate<int[]>) ints -> {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == target) return true;
            }
            return false;
        }).count();
        if (count>=1) return true;
        return false;
    }
    public boolean Find1 (int target, int[][] array) {
        // write code here
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int i1 = Arrays.binarySearch(array[i], target);
                if (i1>=0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
