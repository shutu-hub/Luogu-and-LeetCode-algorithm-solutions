package Hot100;


public class L17 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // nums的长度 1-n,则缺失的第一个正数属于[1,n+1]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0){
                nums[i]=n+1;
            }
        }
        // 3 4 5 1
        // 3 4 -5 1
        // 将数组变成哈希表
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            // 如果 num 在 1-n这个范围，则打上标记
            // 比如 num = 3,则对应数组中索引2的位置应该打上标记，表明2这个数存在，但是在打标记的时候可能会覆盖原有的数，所以在打标记的时候把数值取负数
            // nums[num - 1]会出现已经打了标记，是负数的情况，如果直接取反，则会变成正数，所以要取绝对值
            if (num<=n){
                nums[num-1]=-Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]>0){
                // i+1就是缺失的正数
                return i+1;
            }
        }
        // 遍历完数组，1-n都存在
        return n+1;
    }
}
