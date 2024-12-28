package niuke.string1.middle;

/**
 * @Author pudding
 * @Date 2023/11/22 21:30
 */
public class CompareVersionBM22 {
    /*双指针  依次比较两个字符串每个字符的大小，遇到点就跳过 */
    public static int compare(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0, j = 0;
        //直到某个字符串结束
        while (i < n1 || j < n2) {
            long num1 = 0;
            //从下一个点前截取数字
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            //跳过点
            i++;
            long num2 = 0;
            //从下一个点前截取数字
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            //跳过点
            j++;
            //比较数字大小
            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;
        }
        //版本号相同
        return 0;
    }

    public static int compare1(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int point1 = 0, point2 = 0;
        while (point1 < len1 || point2 < len2) {
            long num1 = 0;
            while (point1 < len1 && version1.charAt(point1) != '.') {
                num1 = num1 * 10 + (version1.charAt(point1) - '0');
                point1++;
            }
            point1++;

            long num2 = 0;
            while (point2 < len2 && version2.charAt(point2) != '.') {
                num2 = num2 * 10 + (version2.charAt(point2) - '0');
                point2++;
            }
            point2++;

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
