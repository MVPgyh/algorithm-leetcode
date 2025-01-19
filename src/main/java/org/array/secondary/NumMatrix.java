package org.array.secondary;

/*前缀和 自己写出的*/
class NumMatrix {

    int[][] numMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int srow = matrix[0].length;
        int scol = matrix.length;
        this.numMatrix = new int[scol + 1][srow + 1];
        int nrow = numMatrix[0].length;
        int ncol = numMatrix.length;
        for (int i = 1; i < ncol; i++) {
            for (int j = 1; j < nrow; j++) {
                numMatrix[i][j] = numMatrix[i][j - 1] + numMatrix[i - 1][j] - numMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return numMatrix[row2 + 1][col2 + 1] - numMatrix[row2 + 1][col1] - numMatrix[row1][col2+1] + numMatrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        NumMatrix numMatrix1 = new NumMatrix(arrs);
        System.out.println(numMatrix1.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix1.sumRegion(1, 1, 2, 2));
    }
}