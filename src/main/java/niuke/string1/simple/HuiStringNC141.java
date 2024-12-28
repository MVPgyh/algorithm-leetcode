package niuke.string1.simple;

/**
 * @Author pudding
 * @Date 2023/11/22 9:21
 */
public class HuiStringNC141 {
    public static boolean judge (String str) {
        // write code here

        int left=0,right=str.length()-1;
        while (left < right) {
            if (str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return  true;
    }
    public static boolean judge1 (String str) {
        // write code here

        StringBuilder stringBuilder = new StringBuilder(str);
        if (stringBuilder.reverse().toString().equals(str)) {
            return true;
        }return false;

    }
    public static void main(String[] args) {
        System.out.println(judge("aaaaaa"));
        System.out.println(judge1("absba"));

    }
}
