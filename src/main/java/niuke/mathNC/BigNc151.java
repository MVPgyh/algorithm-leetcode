package niuke.mathNC;

/**
 * @Author pudding
 * @Date 2023/11/22 9:11
 */
public class BigNc151 {

    public int gcd (int a, int b) {
        // write code here

//        辗转相除法
        if(a%b==0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }

    //暴力解法
    public int gcd1 (int a, int b) {
        // write code here
        int c=1;
        int min = Math.min(a, b);
        if (a%b==0) return b;
        if (b%a==0) return a;
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                c=i;
            }
        }
        return c;


    }
    public static void main(String[] args) {

    }
}
