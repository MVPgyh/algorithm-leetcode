package org.example;

import java.nio.charset.Charset;

public class MinDepth {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth=Math.min(minDepth(root.left),min_depth);
        }
        if (root.right != null) {
            min_depth=Math.min(minDepth(root.right),min_depth);
        }
        return min_depth+1;
    }

    public static void main(String[] args) {
        int maxValue = Integer.MIN_VALUE;
        int f=maxValue+1;
        System.out.println(f);
    }
}
