package org.tree.simple;

import org.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
}
