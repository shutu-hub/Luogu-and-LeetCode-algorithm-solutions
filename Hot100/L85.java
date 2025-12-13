package Hot100;

import java.util.Arrays;

public class L85 {

    public static void main(String[] args) {
        coinChange(new int[]{1},1);

    }

    public static int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount+1];// 组成每个金额所需要的最小硬币个数
        // 当值大于 amount 时代表不可能组成该金额
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 0; i < coins.length ; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果硬币面额小于等于当前金额
                if (coins[i]<=j){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if (dp[amount]>amount){
            return -1;
        }
        return dp[amount];
    }
}
