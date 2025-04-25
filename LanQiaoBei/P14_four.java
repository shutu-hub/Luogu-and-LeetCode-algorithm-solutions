package LanQiaoBei;

import java.util.Scanner;

public class P14_four {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long[]xi=new long[n+1];
        for (int i = 1; i <=n ; i++) {
            xi[i]=scanner.nextLong();
        }
        int[][]array=new int[n][2];
        for (int i = 1; i <n ; i++) {
            // 传送门起点 ai
            array[i][0]=scanner.nextInt();
            // bi
            array[i][1]=scanner.nextInt();
        }
        double[][]dp=new double[n+1][2];
        dp[1][0]=xi[1]+array[1][0]/0.7;
        dp[1][1]=xi[1];
        for (int i = 2; i <n ; i++) {
            if (array[i][0]>array[i-1][1]){
                // 向上爬
                dp[i][0]=Math.min(dp[i-1][0]+(array[i][0]-array[i-1][1])/0.7,dp[i-1][1]+xi[i]-xi[i-1]+array[i][0]/0.7);
            }else{
                dp[i][0]=Math.min(dp[i-1][0]+(array[i-1][1]-array[i][0])/1.3,dp[i-1][1]+xi[i]-xi[i-1]+array[i][0]/0.7);
            }
            dp[i][1]=Math.min(dp[i-1][0]+array[i-1][1]/1.3,dp[i-1][1]+xi[i]-xi[i-1]);
        }
        // 计算出从n-1到n所花费的时间
        double min;
        min=Math.min(dp[n-1][0]+array[n-1][1]/1.3,dp[n-1][1]+xi[n]-xi[n-1]);
        System.out.printf("%.2f",min);
    }
}
