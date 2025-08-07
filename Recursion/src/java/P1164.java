package Recursion.src.java;

import java.util.Scanner;

public class P1164 {

    static int N=0;
    static int M=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int[]values=new int[N];
        // 每种食物的价格
        for (int i = 0; i < N; i++) {
            values[i]= scanner.nextInt();
        }
        // 选第i道菜花光j元钱时的方案数
        int[][]dp=new int[N][M+1];
        for (int i = 1; i <=M ; i++) {
            if (i==values[0]){
                dp[0][i]=1;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                // 买不起这道菜 ==选上一道菜用光j元的方案数
                if (j<values[i]){
                     dp[i][j]=dp[i-1][j];
                }
                // 刚好买这一道菜 ==买这道菜这个方案(1)+不买这道菜时花光j元的方案数
                if (j==values[i]){
                    dp[i][j]=1+dp[i-1][j];
                }
                // 买完这道菜还有剩余 ==不买这道菜花j时的方案数 + 买这道菜花j-values[i]的方案数
                if (j>values[i]){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-values[i]];
                }
            }
        }
        System.out.println(dp[N-1][M]);

    }
    

}
