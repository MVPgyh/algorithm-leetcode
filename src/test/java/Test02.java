import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author pudding
 * @Date 2023/11/22 14:29
 */
public class Test02 {

    @Test
    public void  test01(){
        Integer[] arr = {5,4,7,9,2,12,54,21,1};
        //降序
        Arrays.sort(arr, new Comparator<Integer>() {
            //重写compare方法，最好加注解，不加也没事
            public int compare(Integer a, Integer b) {
                //返回值>0交换
                return b-a;
            }
        });
        String str = "Hello Genius!  ";

    }

    @Test
    public void test02(){
        String s=" wa    ";
        char[] charArray = s.toCharArray();
        int index=0;
        /*推出前有几个空格*/
        /*while (index<s.length()&&charArray[index] == ' ') {
            index++;
        }*/
        for (int i = 0; i < charArray.length && charArray[i]=='\u0020'; i++) {
            index++;
        }
        System.out.println(Arrays.toString(charArray));
        System.out.println(index);

        char a='绗';
        System.out.println(a);
        int b= a;
        System.out.println(b);
    }

    @Test
    public  void  test03(){
        char a='9';
        int b=a-'2';
        System.out.println(b);
    }

    @Test
    public  void  test04(){
        int a=8;
        System.out.println(a >> 1);
        Character b='航';
        char c='航';
        System.out.println(b==c);

        Integer d=121;
        Integer f=121;
        System.out.println(d==f);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add("2121");
        objects.add(212);
        System.out.println(objects.get(objects.size()-1));

    }

    @Test
    public  void  queueTest(){
        Queue<String> objects = new LinkedList<>();
        objects.add("armani");
        objects.add("spore");
        objects.add("athna");
        System.out.println(objects.peek());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects);
    }
}
