package reviewCode;

import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/8 下午10:54
 * 杨辉三角  学会了整形数组转list
 */
public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < numRows+1; i++) {
            int[] ints = new int[i];
            for (int j = 0; j < ints.length; j++) {
                if (j == 0 || j == ints.length - 1) {
                    ints[j]=1;
                }else {
                    List<Integer> integers = lists.get(i - 2);
                    int cur = integers.get(j - 1) + integers.get(j);
                    ints[j]=cur;
                }
            }
            /*整形数组转list*/
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            lists.add(list);
        }
        return lists;
    }
    /*官方解法*/
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < i+1; j++) {
                if(j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        YangHui yangHui = new YangHui();
        System.out.println(yangHui.generate(3));
    }
}
