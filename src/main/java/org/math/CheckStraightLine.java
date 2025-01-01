package org.math;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午9:09
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int currenty=coordinates[i][1]-coordinates[0][1];
            int currentx=coordinates[i][0]-coordinates[0][0];
            if (currentx * y != currenty * x) {
                return false;
            }
        }
        return true;
    }

}
