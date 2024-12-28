package org.example;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(2);
        al.add(21);
        al.add(26);
        al.add(24);
        al.add(21);
        al.add(24);
        /**
         * 并发修改异常出现在 增强for循环 和 iterator中
         * 解决方法
         * 1、使用普通for循环
         * 2、使用iterator接口自带的remove方法
         * filter流等等
         *
         *
         * */
        //不会发生并发修改异常
        for (int i =0; i< al.size(); i++) {
            Integer integer = al.get(i);
            if (integer == 21) {
                al.remove(i);
            }
            /*Integer integer1 = al.get(i-1);
            if (integer1 == integer) {
                al.remove(integer);
            }*/
        }
        System.out.println(al);
    }
}
