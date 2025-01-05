import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午6:51
 */
public class Test04 {
    @Test
    public  void convertDateToBinary(){
        int[] a={21,32,2,34,23};
        int[] b=new int[a.length];
        System.arraycopy(a,0,b,0,a.length-1);
        Arrays.sort(a,1,a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


        int c=10;
        int d=c;
        c=2100;
        System.out.println(d);
        System.out.println(c);
    }

    @Test
    void  test05(){
        Year year = new Year(2025);
        year.setEveryThing("bad");
        year.setSucceed(false);
        updateYear(year);
        System.out.println(year.getEveryThing());
        System.out.println(year.isSucceed());

    }

    public void updateYear(Year year) {
        year.setSucceed(true);
        year.setEveryThing("good");
    }
}
