package org.example;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void reverseString(char[] s) {
        int len=s.length;
        int left=0;
        int right=len-1;
        while (left < right) {
            char temp;
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(4, new TreeNode(1), new TreeNode(3));
        invertTree(root);*/
        char [] s={'h','e','l','l','o'};
        reverseString(s);
        System.out.println('a'+'c');
        int a=-100;
        char b=(char) a;
        System.out.println(b);
    }
}