package org.array.secondary;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/10 下午11:02
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int left=0,right=matrix[0].length-1;
            if (matrix[i][left] <= target && matrix[i][right] >= target) {
                while (left <= right) {
                    int mid=(right-left)/2+left;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        right=mid-1;
                    }else {
                        left=mid+1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arrs={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] arrs={{1,3}};
        System.out.println(searchMatrix(arrs, 3));
    }
}
