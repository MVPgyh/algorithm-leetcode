package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/30 下午8:28
 */
public class FindTheDistanceValue {
    public static void main(String[] args) {

    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int res=0;
        for (int i = 0; i < l1; i++) {
            int aNum = arr1[i];
            int flag=1;
            for (int j = 0; j < l2; j++) {
                int bNum = arr2[j];
                if (Math.abs(aNum-bNum)<=d) {
                    flag=0;
                    break;
                }
            }
            if (flag == 1) {
                res++;
            }
        }
        return res;

    }
}
