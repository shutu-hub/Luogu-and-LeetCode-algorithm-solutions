package Hot100;

public class L47 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
            // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] 输出: [3,9,20,null,null,15,7]
        return digui(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode digui(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
//        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 该节点的左子树为
        int index=0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i]==preorder[preLeft]){
                index=i;
                break;
            }
        }
        // 细节：计算左子树的长度(index是当前根节点在中序遍历的位置，该中序遍历的左边都是左子树)，
        // 知道了左子树的长度，就可以计算出右子树的根节点索引 preLeft+leftLength+1
        int leftLength = index-inLeft;
        // 0-index-1 左子树的中序遍历  index+1-inRight 右子树的中序遍历
        if (index>inLeft){
            root.left = digui(preorder,preLeft+1,preLeft+leftLength,inorder,inLeft,index-1);
        }
        if (index<inRight){
            root.right = digui(preorder,preLeft+leftLength+1,preRight,inorder,index+1,inRight);
        }
       return root;
    }
}
