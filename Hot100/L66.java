package Hot100;

public class L66 {

    public int search(int[] nums, int target) {
        // 先找到分界点，在分界点左侧二分查找，在分界点右侧二分查找
        if(nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0]==target?0:-1;
        }
        int left=0; int right=nums.length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[mid]==target){
                return mid;
            }
            // 1 2 3 5 6 //  3 5 6 1 2 // 5 6 1 2 3
            if (nums[0]<=nums[mid]){
                // 左区间有序
                if (nums[0]<=target && target<nums[mid]){
                    // 在左区间范围内，调整右指针
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if (nums[mid]<target && target<=nums[nums.length-1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
