package Hot100;

public class L84 {

    public static void main(String[] args) {
        numSquares(12);
    }

    public static int numSquares(int n) {
       int[] dp = new int[n+1];
       dp[1]=1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE-1;
            for (int j = 1; j * j <= i ; j++) { // j的范围不会超过 根号i，超过根号i该数的平方和会大于i
                min = Math.min(min,dp[i-j*j]+1);// i-j*j + j*j 为组成 i 的最少完全平方数数量
            }
            dp[i]=min;
        }
        return dp[n];
    }
}
