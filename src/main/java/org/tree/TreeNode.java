package org.tree;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/13 下午9:27
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
