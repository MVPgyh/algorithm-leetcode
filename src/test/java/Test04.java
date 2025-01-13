import org.junit.jupiter.api.Test;
import org.linkedList.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

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
        String s="the sky is    blue";
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(s.split(" ").length);
        System.out.println("==========================");
        String s1="abcd";
        String s2="abcd";
        System.out.println(s1.equals(s2));
        System.out.println("==============");

        char a='8';
        System.out.println((int) a);



    }

    @Test
    public void  test06(){
        String s="[[1,3],[2,6],[8,10],[15,18]]";
        String replace = s.replace('[', '{');
        String res = replace.replace(']', '}');
        System.out.println(res);

    }

    @Test
    public void  test07(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next=second;

        ListNode temp=first;
        System.out.println(temp.next.equals(first.next));

    }

    @Test
    public void  test08(){
        Integer[] arr={21,32,43,12,32};
        Arrays.sort(arr, (o1, o2) -> -1);
        System.out.println(Arrays.toString(arr));
    }
}
