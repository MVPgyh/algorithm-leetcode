package org.tree.simple;

import org.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/13 下午10:34
 */
/*前序遍历 二叉树 根左右*/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        /*用于存放结果集*/
        List<Integer> result = new ArrayList<>();
        /*遍历根节点*/
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        /*遍历左节点*/
        preorder(root.left, result);
        /*遍历右节点*/
        preorder(root.right, result);
    }

    /*迭代遍历二叉树 前序遍历 TODO 迭代法遍历二叉树需要使用到栈*/
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        /*创建一个栈*/
        Stack<TreeNode> stack = new Stack<>();
        /*把当前节点添加到栈*/
        stack.push(root);
        /*如果栈不为空一直遍历*/
        while (!stack.isEmpty()){
            /*弹出栈顶元素*/
            TreeNode node = stack.pop();
            /*添加到结果集中*/
            result.add(node.val);

            /*这里添加到栈的顺序不能更改，先把右子树入栈则后出 左子树后入先出   则顺序为中左右*/
            /*如果他的右节点不为空 也添加到栈里面*/
            if (node.right != null){
                stack.push(node.right);
            }
            /*如果他的左节点不为空 也添加到栈里面*/
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }


}
