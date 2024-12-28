package org.example;




public class TreeNode {
   public int val;
    public TreeNode left;
   public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void preShow(){
        if (this==null){
            System.out.println("该树为空!");
            return; //方法执行结束
        }
        System.out.print(this.val+" "); //输出节点

        if(this.left!=null){//遍历左节点
            this.left.preShow();
        }

        if (this.right!=null){ //遍历右节点
            this.right.preShow();
        }
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
