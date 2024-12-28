package org.array.secondary;

public class MaxArea11 {
    //暴力解法超时 即使结果正确，超时也不能通过
    public  static int maxArea(int[] height) {
        int maxarea=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int eacharea=h*(j-i);
                maxarea=Math.max(maxarea,eacharea);
            }
        }
        return maxarea;
    }
    public  static int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
