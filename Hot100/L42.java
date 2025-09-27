package Hot100;

public class L42 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        return digui(nums,0,nums.length-1);
    }

    /**
     * 二叉搜索树的中序遍历为升序数组
     * 将有序数组构造成二叉搜索树核心思想是:先确定根节点，那么根节点的左节点范围就是根节点在数组左边的范围，右节点范围就是根节点在数组右边的范围
     * 构造每一个节点的过程是一样的，并且范围在缩小，采用递归过程
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode digui(int[] nums, int left, int right) {
        if (left>right){
            return null;
        }
        // 取中间节点左边的节点为根节点
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = digui(nums,left,mid-1);
        root.right = digui(nums,mid+1,right);
        return root;
    }
}
