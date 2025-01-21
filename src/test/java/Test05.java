import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.function.BiFunction;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/18 下午6:42
 */
public class Test05 {
    @Test
    public  void test01(){
        System.out.println("SD@!.;dwadw".toLowerCase());
        System.out.println(Character.isLetter('!'));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("efsef",32);
        Integer efsef = map.merge("efsef", 2332, Integer::sum);
        System.out.println(efsef);
        System.out.println(map);
        System.out.println("==================================");
        /*加减乘除的优先级高于左右位移*/
        System.out.println(7+1<<2);
    }



    @Test
    public void  test02(){
        String s="-00021";
        System.out.println(Integer.parseInt(s));
    }
}
