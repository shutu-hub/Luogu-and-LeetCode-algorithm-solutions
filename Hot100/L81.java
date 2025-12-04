package Hot100;

public class L81 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        if (n==1){
            return 1;
        }
        dp[2]=2;
        for (int i = 3; i <= n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
