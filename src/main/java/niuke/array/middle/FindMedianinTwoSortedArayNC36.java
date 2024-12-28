package niuke.array.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author pudding
 * @Date 2023/11/22 19:50
 */
public class FindMedianinTwoSortedArayNC36 {
    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        // write code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            arrayList.add(arr1[i]);
            arrayList.add(arr2[i]);
        }
        arrayList.sort(Comparator.comparingInt(o -> o));
        return arrayList.get(arrayList.size() / 2 - 1);

    }

    public static int findMedianinTwoSortedAray1(int[] arr1, int[] arr2) {
        if (arr1.length == 1) {
            return Math.min(arr1[0], arr2[0]);
        }
        int left1 = 0;
        int right1 = arr1.length - 1;

        int left2 = 0;
        int right2 = arr2.length - 1;

        while (left1 < right1) {
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = left2 + (right2 - left2) / 2;
            int jiOu=((right1-left1+1)%2==0?1:0);

            if (arr1[mid1] == arr2[mid2]) {
                return arr1[mid1];
            } else if (arr1[mid1]>arr2[mid2]) {
                left2=mid2+jiOu;
                right1=mid1;

            }else {
                left1=mid1+jiOu;
                right2=mid2;
            }

        }
        return Math.min(arr1[left1],arr2[left2]);

    }

    public static void main(String[] args) {

    }
}
