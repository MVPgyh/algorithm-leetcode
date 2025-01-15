package org.tree.simple;

import org.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/13 下午9:18
 */
/*中序遍历二叉树  递归法*/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /*代码随想录 迭代法 中序遍历*/
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        /*当前节点为根节点*/
        TreeNode cur = root;

        /*如果当前节点不为null或者 栈不为空 就循环*/
        while (cur != null || !stack.isEmpty()){
            /*如果当前节点不为空 则添加到栈里面，并把当前节点设置为该节点的左节点*/
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
                /*如果当前节点为null了 弹出该元素 并添加到结果集里面 把向前节点设置为该节点的右节点*/
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }





}
