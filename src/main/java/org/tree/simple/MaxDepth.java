package org.tree.simple;

import org.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/19 下午7:30
 */
public class MaxDepth {
    /*广度优先+队列*/
    public int maxDepth(TreeNode root) {
        int res=0;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }

    /*递归方法*/
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left),maxDepth1(root.right))+1;
    }
}
