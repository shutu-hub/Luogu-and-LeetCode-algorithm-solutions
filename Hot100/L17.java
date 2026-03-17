package Hot100;


public class L17 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }

    //  3 4  5  1
    // -1 4 -3 -4
    public static int firstMissingPositive(int[] nums) {
       // 长度为1-n的数组，其最小正整数必然在 1-n+1
       // 数组长度为1-n，那就把这个数组当作为map，遍历数组如果这个数在1-n范围内，则将其改为-nums[i]
       // 最后检查数组，如果nums[i]=负数，则这个正数存在，如果等于正数则这个数就是缺失的最小正数
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0){
                nums[i]=n+1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs<=n){
                nums[abs-1]= -Math.abs(nums[abs-1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return i+1;// i从0开始，需要+1映射
            }
        }
        return n+1;
    }
}
