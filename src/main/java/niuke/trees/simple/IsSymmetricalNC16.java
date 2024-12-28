package niuke.trees.simple;

import niuke.trees.TreeNode;

/**
 * @Author pudding
 * @Date 2023/11/26 12:22
 */
public class IsSymmetricalNC16 {
    boolean recursion(TreeNode root1, TreeNode root2) {
        //可以两个都为空
        if (root1 == null && root2 == null)
            return true;
        //只有一个为空或者节点值不同，必定不对称
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        //每层对应的节点进入递归比较
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return recursion(pRoot, pRoot);
    }

    public static void main(String[] args) {

    }
}
