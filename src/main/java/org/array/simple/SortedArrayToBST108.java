package org.array.simple;

import org.example.TreeNode;

import java.util.Arrays;

public class SortedArrayToBST108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int min=(start+end)/2;
        TreeNode root = new TreeNode(nums[min]);
        root.left=helper(nums,start,min-1);
        root.right=helper(nums,min+1,end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        treeNode.preShow();
    }
}
