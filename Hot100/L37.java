package Hot100;

public class L37 {
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
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return digui(root);
    }

    public int digui(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            // 该节点为叶子节点
            return 1;
        }
        // 计算该节点左边的高度和右边的高度
        int leftHeight = digui(root.left);
        int rightHeight = digui(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
