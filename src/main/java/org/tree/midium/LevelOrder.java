package org.tree.midium;

import org.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/15 下午10:04
 */
public class LevelOrder {
    public static void main(String[] args) {

    }
    ArrayList<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

//        checkFun01(root,0);
        checkFun02(root);
        return resList;
    }
    //BFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        /*使用到队列*/
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        /*往队列插入元素*/
        que.offer(node);

        /*队列不为空*/
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            /*队列长度*/
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                /*队列中添加 当前元素值*/
                itemList.add(tmpNode.val);

                /*往队列添加 左子树和右子树的*/
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }

    }


}
