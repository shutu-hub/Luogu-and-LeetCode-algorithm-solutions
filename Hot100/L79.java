package Hot100;

import java.util.Arrays;

public class L79 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }

    public static int jump(int[] nums) {
        int[]dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i+j<nums.length){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
