package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L45 {

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

    public List<Integer> rightSideView(TreeNode root) {
        // 返回每一层最右侧的元素
        // 在i=count的时候该元素是最后一个元素，把该元素加进去
        List<Integer> res=new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()){
            int nextCount=0;
            for (int i = 1; i <= count; i++) {
                TreeNode poll = queue.poll();
                if (i==count){
                    // 该层最后一个节点
                    res.add(poll.val);
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                    nextCount++;
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    nextCount++;
                }
            }
            count=nextCount;
        }
        return res;
    }
}
