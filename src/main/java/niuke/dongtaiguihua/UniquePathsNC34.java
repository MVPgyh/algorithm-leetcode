package niuke.dongtaiguihua;

/**
 * @Author pudding
 * @Date 2023/11/26 13:09
 */
public class UniquePathsNC34 {
    public int uniquePaths (int m, int n) {
        // write code here
        if (m==1||n==1) return 1;
        return  uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

    public static void main(String[] args) {

    }
}
