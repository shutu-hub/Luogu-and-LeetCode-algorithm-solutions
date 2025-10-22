package Hot100;

public class L63 {

    // 在查找过程中，nums[mid]<target时，left会左移，因为target不会出现在mid及其左边，nums[mid]>target时，right会右移，因为target不会出现在mid及其右边
    // 所以当循环结束时：所有小于 target 的元素都在 left 左边；所有大于 target 的元素都在 left 右边；
    // left 始终指向第一个大于等于 target 的位置，当 target 不存在时，它就是插入位置。
    public int searchInsert(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[mid]<target){
                left = mid+1;
            }else if (nums[mid]>target){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
