package org.tree.simple;

import org.tree.TreeNode;

import java.util.*;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/13 下午10:55
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }


    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        inorder(root.right, res);
        res.add(root.val);
    }

    /*迭代法 后续遍历 左右根 官方解法*/
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                /*当前节点的右节点不为null再次添加队列中*/
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /*代码随想录的后续遍历 迭代方法的代码*/
//    后序遍历可以看成 先序遍历的倒转
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
