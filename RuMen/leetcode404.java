package RuMen;

import javax.swing.tree.TreeNode;

public class leetcode404 {
    public static void main(String[] args) {

    }

    /**
     * 左叶子之和
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root){
        if (root==null){
            return 0;
        }
        int sum=0;
        if (root.left!=null){
            if (root.left.left==null && root.left.right==null){
                // 左孩子为叶子节点
                sum+=root.left.val;
            }else{
                sum+=sumOfLeftLeaves(root.left);
            }
            sum+=sumOfLeftLeaves(root.right);
        }else{
            sum+=sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
