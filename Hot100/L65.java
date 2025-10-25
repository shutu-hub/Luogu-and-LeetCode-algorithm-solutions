package Hot100;

public class L65 {

    public int[] searchRange(int[] nums, int target) {
        int min = getMin(nums, target);
        if (min==-1){
            return new int[]{-1,-1};
        }
        int max = getMax(nums, target);
        return new int[]{min,max};
    }

    public int getMin(int[]nums,int target){
        int left = 0;int right = nums.length-1;
        int res=-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]<target){
                left = mid+1;
            }else{
                res=mid;
                right= mid-1;
            }
        }
        return res;
    }

    public int getMax(int[]nums,int target){
        int left = 0;int right = nums.length-1;
        int res=-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]<target){
                left = mid+1;
            }else{
                res=mid;
                left=mid+1;
            }
        }
        return res;
    }
}
