package org.tree.simple;

import org.tree.TreeNode;

import java.util.Deque;
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

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                arr[i] = node.val;



                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }

            }
            if (!duichen(arr)) {
                return false;
            }

        }
        return true;
    }

    public boolean duichen(int[] nums) {
        int len = nums.length,left=0,right=len-1;
        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode lr = new TreeNode(2);
        TreeNode rl = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        left.right=lr;
        TreeNode right = new TreeNode(2);
        right.left=rl;
        TreeNode root = new TreeNode(1, left, right);
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(root));
    }
}
