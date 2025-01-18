import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午6:42
 */
public class Test05 {
    @Test
    public  void test01(){
        String s1="abcdefgef";
        String s2="gef";
        System.out.println(s1.startsWith(s2,6));
    }
}
