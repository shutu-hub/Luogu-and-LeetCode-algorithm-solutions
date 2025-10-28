package Hot100;

import java.util.LinkedList;

public class L48 {

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
    int count=0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root==null)return 0;
        // 枚举出所有路径，一一判断是否满足
        // 遍历所有节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            digui(poll,targetSum,0);
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        return count;
    }

    public void digui(TreeNode root,int targetSum,long currentSum){
        if (root==null) return;
        currentSum+=root.val;
        if (currentSum==targetSum)count++;
        // 左子树
        digui(root.left,targetSum,currentSum);
        digui(root.right,targetSum,currentSum);
    }


}
