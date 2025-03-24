package DynamicPrograming;

import java.util.Scanner;


public class P1616 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[]times=new int[m];
        int[]values=new int[m];
        for (int i = 0; i < m; i++) {
            times[i]=scanner.nextInt();
            values[i]=scanner.nextInt();
        }
        long[][]dp=new long[m][t+1];
        for (int i = 1; i <=t ; i++) {
            if (i>=times[0]){
                dp[0][i]=dp[0][i-times[0]]+values[0];
            }else{
                dp[0][i]=dp[0][i-1];
            }
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 0; j <=t ; j++) {
                if (j>=times[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-times[i]]+values[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m-1][t]);
    }
}
