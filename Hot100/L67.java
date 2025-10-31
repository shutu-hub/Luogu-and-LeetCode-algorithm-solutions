package Hot100;

public class L67 {

    /**
     * 寻找旋转排序数组的最小值
     * 旋转n次后，会将原来的数组分为两半，两半都是局部有序，前一半的最小值大于后一半的最大值
     * 要寻找的最小值，其实就是后一半的第一个值
     * 1 2 3 5 6 旋转一次后 -> 6 1 2 3 5 前一半是6，后一半是 1 2 3 5
     * 第一次二分查找取值到2，2左边无序，右边有序，右边的最小值就是2，我们需要继续搜索左边的最小值，因为后一半的第一个数可能在左边
     * 将搜索区域改为无序区域，继续开始搜索
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        int left = 0; int right = n-1;
        int min=Integer.MAX_VALUE;
        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[0]<=nums[mid]){
                min=Math.min(min,nums[0]);
                // 左边区域不需要再搜索了，将搜索区域改为右边的无序区域
                left=mid+1;
            }else{
                min=Math.min(min,nums[mid]);
                // 右边区域不需要再搜索了，将搜索区域改为左边的无序区域
                right=mid-1;
            }
        }
        return min;
    }
}
