package org.tree.simple;

import org.tree.TreeNode;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午7:15
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*都为null返回true*/
        if (p == null && q == null) {
            return true;
        }
        /*两个之间有一个为null的返回false*/
        if (p == null || q == null) {
            return false;
        }
        /*两个都不为null*/
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
