package org.array.secondary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class MyCalendar {
    List<int[]> booked;

    public MyCalendar() {
        booked= new ArrayList<>();
    }

    /*通过直接遍历  记录所有已经预定的课程安排取件， 如果有冲突 返回false*/
    public boolean book(int startTime, int endTime) {
//        遍历数组
        for (int[] ints : booked) {
            int l=ints[0],r=ints[1];
//          如果开始时间小于结束时间，并且开始时间小于结束时间 直接返回false
//            对于两个区间 [s
            if (l < endTime && startTime < r) {
                return false;
            }
            TreeSet<int[]> ints1 = new TreeSet<>((o1, o2) -> o1[0]-o2[0]);
        }
        booked.add(new int[]{startTime,endTime});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10,20);
        myCalendar.book(20,30);
        myCalendar.book(25,35);
    }
}