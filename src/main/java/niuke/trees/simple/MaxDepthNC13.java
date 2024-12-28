package niuke.trees.simple;

import niuke.trees.TreeNode;

/**
 * @Author pudding
 * @Date 2023/11/26 11:50
 */
public class MaxDepthNC13 {
    /**
     * 求给定二叉树的最大深度，
     * 深度是指树的根节点到任一叶子节点路径上节点的数量。
     * 最大深度是所有叶子节点的深度的最大值。
     * （注：叶子节点是指没有子节点的节点。）
     * @param root
     * @return
     */
    public static int maxDepth (TreeNode root) {
        // write code here
        if (root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left=left;
        System.out.println(maxDepth(root));

    }
}
