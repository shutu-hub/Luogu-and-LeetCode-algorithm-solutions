package DynamicPrograming;

import java.util.Scanner;

public class P1077 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m=  scanner.nextInt();
        int[]max=new int[n+1];
        for (int i = 1; i <= n; i++) {
            max[i]=scanner.nextInt();
        }
        // dp[i][j]表示第i个数时花的总和为j时的方案数
        int[][]dp=new int[n+1][m+1];
        int mod=(int)1e6+7;
        // 初始化 每种花摆放0盘时 都有一种方案
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                // 这个花不是有选和不选两种选择，而是在0-max[i]中选一个情况 所以多一层for循环迭代出不同情况
                for (int k = 0; k <= Math.min(j,max[i]) ; k++) {
                    dp[i][j]=(dp[i][j]+dp[i-1][j-k])%mod;
                }
            }
        }
        System.out.println(dp[n][m]%mod);
    }
}
