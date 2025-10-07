package Hot100;

public class L49 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==root || q==root){
            // 要找的节点是当前搜索的根节点，则该节点就是祖先节点，直接返回即可
            return root;
        }
        // 判断 p,q 节点在 root 的左子树还是右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null){
            // p,q 分别在左子树和右子树
            return root;
        }
        return left!=null?left:right;
    }
}
