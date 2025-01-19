package org.tree.simple;

import org.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午6:03
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


    /*递归写法 判断是否为对称*/
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        /**/
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    /*把根节点入队两次 迭代法（迭代只能采用后序遍历）*/
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check1(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode lr = new TreeNode(2);
        TreeNode rl = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        left.right = lr;
        TreeNode right = new TreeNode(2);
        right.left = rl;
        TreeNode root = new TreeNode(1, left, right);
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(root));
    }
}
