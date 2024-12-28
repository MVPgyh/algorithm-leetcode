package niuke.trees.simple;


import niuke.trees.TreeNode;

import java.util.*;

/**
 * @Author pudding
 * @Date 2023/11/24 20:18
 */
public class LowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here 两种方法 宽度和深度
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val,Integer.MIN_VALUE);
        queue.add(root);

        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left.val,node.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right.val,node.val);
                queue.add(node.right);
            }

        }

        HashSet<Integer> hashSet = new HashSet<>();
        while (parent.containsKey(o1)) {
            hashSet.add(o1);
           o1= parent.get(o1);
        }
        while (!hashSet.contains(o2)) {
           o2= parent.get(o2);
        }
        return o2;


    }
    public static void main(String[] args) {

    }
}
