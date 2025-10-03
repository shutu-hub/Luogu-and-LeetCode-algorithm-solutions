package Hot100;

public class L50 {

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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 该节点的最大路径和 : 左节点的最大路径和 + 右节点的最大路径和 + 当前节点的值
        // 定义一个全局变量，不断刷新结果
        maxGin(root);
        return res;
    }

    private int maxGin(TreeNode root) {
        if (root==null){
            return 0;
        }

        // 求该节点的最大路径和 (该节点是最顶部的头节点，左右孩子节点的路径和都可以参与计算)
        int left = maxGin(root.left);
        int right = maxGin(root.right);
        if (left<0)left=0;
        if (right<0)right=0;
        int cur = left+right+root.val;
        res = Math.max(res,cur);

        // 返回该节点可以贡献的路径和，这里是单边的，左边或者右边，因为返回结果的时候，这个节点不是头节点
        return Math.max(left,right)+root.val;
    }

}
