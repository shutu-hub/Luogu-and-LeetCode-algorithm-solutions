package Hot100;

public class L44 {

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

    int ans;
    int count; // 用全局变量来记录次数，递归调用中，每次递归调用都会改变，如果使用局部变量，则回到父方法时，值依然是父方法开始时的值

    public int kthSmallest(TreeNode root, int k) {
        // 二叉搜索树的中序遍历是升序序列，所以中序遍历的序列中第k个元素就是第k小的元素
        count=k;
         digui(root);
         return ans;
    }

    private void digui(TreeNode root) {
        if (root==null){
            return;
        }
        digui(root.left);
        count--;
        if (count==0){
            ans=root.val;
            return;
        }
        digui(root.right);
    }
}
