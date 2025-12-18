package Hot100;

import java.util.Arrays;

public class L87 {

    public static void main(String[] args) {
        System.out.println(new L87().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];// 到每一位时的最长子序列长度
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    // 形成递增序列
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int max = 0;
        for (int ele : dp) {
            max=Math.max(max,ele);
        }
        return max;
    }
}
