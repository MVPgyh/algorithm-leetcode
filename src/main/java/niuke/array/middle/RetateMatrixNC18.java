package niuke.array.middle;

/**
 * @Author pudding
 * @Date 2023/11/24 21:06
 */
public class RetateMatrixNC18 {
    public int[][] rotateMatrix (int[][] mat, int n) {
        // write code here
        int[][] res=new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int num = mat[i][j];
                res[j][n-1-i]=num;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
