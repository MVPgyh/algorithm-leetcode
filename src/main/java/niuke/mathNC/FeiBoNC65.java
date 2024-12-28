package niuke.mathNC;

/**
 * @Author pudding
 * @Date 2023/11/22 9:39
 */
public class FeiBoNC65 {
    public static int Fibonacci (int n) {
        if (n == 1||n==2) {
            return  1;
        }
        n=Fibonacci(n-2)+Fibonacci(n-1);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}
