package org.array.simple;

import java.util.ArrayList;

public class CanJump {
    public static boolean canJump(int[] nums) {
        int reach=0,n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return  false;
            }
            reach=Math.max(i+nums[i],reach);
        }
        return true;
    }

    public static void backtrack() {

    }

    public static void main(String[] args) {


    }
}
