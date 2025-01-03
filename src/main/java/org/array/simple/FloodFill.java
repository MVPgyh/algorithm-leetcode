package org.array.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/3 下午9:33
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length, c = image[0].length;
        int centor = image[sr][sc];
        if (centor==color) return image;

        return null;

    }



    public static void main(String[] args) {

    }
}
