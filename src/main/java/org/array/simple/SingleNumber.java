package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/9 上午12:12
 */
public class SingleNumber {
    /*采用异或，其余都是偶数位，就有一个数是奇数位的问题*/
    public static int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
}
