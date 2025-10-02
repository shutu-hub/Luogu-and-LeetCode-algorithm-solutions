package Hot100;

public class L46 {

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

    public void flatten(TreeNode root) {
        digui(root);
    }

    /**
     * 返回根和尾部节点
     * 返回头节点是和前边连接，返回尾节点是和后边连接
     * @param root
     * @return
     */
    private TreeNode[] digui(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode[] leftNode = digui(root.left);
        TreeNode[] rightNode = digui(root.right);
        TreeNode tail = root;
        if (leftNode!=null){
            tail.right=leftNode[0];
            tail = leftNode[1];
        }
        if (rightNode!=null){
            tail.right=rightNode[0];
            tail = rightNode[1];
        }
        root.left=null;
        return new TreeNode[]{root,tail};
    }
}
