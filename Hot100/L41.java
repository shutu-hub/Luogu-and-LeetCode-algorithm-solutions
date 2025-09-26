package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L41 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int geshu=0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                    geshu++;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    geshu++;
                }
            }
            count=geshu;
            lists.add(list);
        }
        return lists;
    }
}
