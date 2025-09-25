package Hot100;

public class L40 {

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

    int res = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        return deepth(root)-1;
    }

    public int deepth(TreeNode node){
        if (node==null){
            return 0;
        }
        if (node.left==null && node.right==null){
            return 1;
        }
        int leftDeepth = deepth(node.left);
        int rightDeepth = deepth(node.right);
        res = Math.max(res,leftDeepth+rightDeepth+1);
        return Math.max(leftDeepth,rightDeepth)+1;
    }
}
