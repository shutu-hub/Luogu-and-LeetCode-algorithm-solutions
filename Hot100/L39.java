package Hot100;

public class L39 {

    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left==null && root.right == null){
            return true;
        }
        return digui(root.left, root.right);
    }

    private boolean digui(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
       if (left.val!=right.val){
           return false;
       }
       return digui(left.left,right.right) && digui(left.right,right.left);
    }
}
