import org.junit.jupiter.api.Test;

import java.util.*;

public class Test01 {
    @Test
    public static int[] twoSum(int[] nums, int target) {
        //创建一个hashmap集合 键值对方式
        Map<Integer, Integer> map = new HashMap<>();
//        循环数组
        for(int i = 0; i< nums.length; i++) {
//           判断集合键中是否存在要找的数
            if(map.containsKey(target - nums[i])) {
//                存在就返回
                return new int[] {map.get(target-nums[i]),i};
            }
//            不存在就把数组值和其下标添加到集合中
            map.put(nums[i], i);
        }
        return  new int[1];
    }

    //使用贪心策略 使用贪心算法求出操作次数
    //排序+模拟
    public static int minimumOperations(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        //0 1 3 5 5
        int result=0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                int x=nums[i];
                for (int j = i; j < len; j++) {
                    nums[j]-=x;
                }
                result++;
            }
        }
        return  result;
    }

    //本质上就是找不为0的正整数数量
    public static int minimumOperationsMap(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    @Test
    public  void  test01(){
        System.out.println(212);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asd");
        stringBuilder.insert(0,"v");
        stringBuilder.insert(0,"o");
        stringBuilder.insert(0,"p");
        stringBuilder.append(" ");
        stringBuilder.insert(7,"q");
        System.out.println(stringBuilder.toString());

    }

    @Test
    public  void  test02(){
        System.out.println(Integer.valueOf("000010111"));

        System.out.println("a4123".charAt(0));
        System.out.println((int) 'a');
        System.out.println(Integer.valueOf('a'));
        String[] split = "dw:dwa::dwa".split(":");
        System.out.println(split[2].equals("  "));
        System.out.println(Arrays.toString("dw:dwa::dwa".split(":")));

    }
    @Test
    public  void  test03(){
        System.out.println("dwadfa".matches("dwada\\*"));
        System.out.println(Arrays.toString("127.0.0.1.".split("\\.")));
        System.out.println(new StringBuilder().insert(0," ").insert(0,""));
        int a="213".charAt(0);
        char b="213".charAt(1);
        System.out.println(a);
        System.out.println(b);

        System.out.println(Integer.valueOf('1'));

        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = "sdawd".toCharArray();
        stringBuilder.insert(0,charArray,1,2);
        System.out.println(stringBuilder);
    }

    @Test
    public  void  test04(){
        int i = "21".charAt(0)-'0';
        System.out.println(i);
        int a= " ".charAt(0)-'0';
        System.out.println(a);

        System.out.println(UUID.randomUUID());

//        包前不包后
        System.out.println("sdadwa".substring(0,3));
    }




}
