package Hot100;

public class L4 {
    public static void main(String[] args) {
        moveZeroess(new int[]{0,1,0,3,12});
    }

    public static void moveZeroess(int[] nums) {
        // 方法一：将所有元素移动到开头，末尾直接补0
        // 方法二：双指针，将0元素
        // 1 0 0 3 2 0
        // 1 3 0 0 2 0
        // 1 3 2 0 0 0
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                // 找到该元素后第一个不为0的数，交换
                int right=i+1;
                while(right<nums.length){
                    if(nums[right]!=0){
                        nums[i]=nums[right];
                        nums[right]=0;
                        break;
                    }
                    right++;
                }
            }
        }
        for(int ele:nums){
            System.out.println(ele);
        }
    }

    /**
     * 法一:双指针
     * 思想：将不为0的数依次左移 (通过和左边的 0 交换位置实现)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n=nums.length;int left=0;int right=0;
        // 0 1 0 3 12
        // 1 0 0 3 12
        // 1 3 0 0 12
        // 1 3 12 0 0
        while (right<n){
            if (nums[right]!=0){
                // 左移
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[]nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

//    public void moveZeroes(int[] nums) {
//        // 如果这个数不是0 则前移 最后将末尾的数全都置为0
//        int k=0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]!=0){
//                nums[k++]=nums[i];
//            }
//        }
//        // k-nums.length-1 置为0
//        for (int i = k; i < nums.length; i++) {
//            nums[i]=0;
//        }
//    }
}
