package Hot100;

public class L43 {

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
    public boolean isValidBST(TreeNode root) {
        return digui(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean digui(TreeNode root,long lower,long upper) {
        if (root==null){
            return true;
        }
        if (root.val>=upper){
            return false;
        }
        if (root.val<=lower){
            return false;
        }
       return digui(root.left,lower,root.val) && digui(root.right,root.val,upper);
    }
}
