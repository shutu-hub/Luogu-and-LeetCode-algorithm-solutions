package DynamicPrograming;

import java.util.Scanner;

public class P1049 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int[]weights=new int[n];
        for (int i = 0; i < n; i++) {
            weights[i]=scanner.nextInt();
        }
        long[][]dp=new long[n][v+1];
        for (int i = 0; i <=v ; i++) {
            if (i>=weights[0]){
                dp[0][i]=weights[0];
            }
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=v ; j++) {
                if (j>=weights[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+weights[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(v-dp[n-1][v]);
    }
}

