package Hot100;

public class L83 {
    public static void main(String[] args) {
        rob(new int[]{2,1,1,2});
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length==1)return nums[0];
        if (nums.length==2)return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);// 这里到第二个房间能偷到的最大值应该是第一个房间和第二个房间中较大的那个
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);// 到前一个房间能偷到的最大值，或者到前两个房间能偷到最大值+当前房间的值
        }
        return dp[nums.length-1];
    }
}

