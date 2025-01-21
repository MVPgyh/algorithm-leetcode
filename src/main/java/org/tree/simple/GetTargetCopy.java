package org.tree.simple;

import org.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/21 下午9:59
 */
public class GetTargetCopy {
    /*dfs*/
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return  null;
        }
        if (original == target) {
            return  cloned;
        }
        TreeNode leftNode = getTargetCopy(original.left, cloned.left,target);
        if (leftNode != null) {
            return leftNode;
        }
        return getTargetCopy(original.right,cloned.right,target);
    }


    /*bfs 用栈模拟*/
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q1 = new ArrayDeque<TreeNode>(), q2 = new ArrayDeque<TreeNode>();
        q1.offer(original);
        q2.offer(cloned);
        while (q1.size() > 0) {
            TreeNode node1 = q1.poll(), node2 = q2.poll();
            if (node1 == target) {
                return node2;
            }
            if (node1.left != null) {
                q1.offer(node1.left);
                q2.offer(node2.left);
            }
            if (node1.right != null) {
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
        }
        return null; // impossible case
    }
}
