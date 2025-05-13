package RuMen;

public class LintCode97 {
    public static void main(String[] args) {
        /**
         *   2
         *  1 3
         * 1
         */
    }
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}

   class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }