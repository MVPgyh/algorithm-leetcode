package niuke.array.middle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(S);
        backtracking(S,res,path,0);
        return res;


    }

    public void backtracking(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,res,path,i+1);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {


    }
}