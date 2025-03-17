package DynamicPrograming;

import java.util.Scanner;

public class P3842 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]l=new int[n];
        int[]r=new int[n];
        for (int i = 0; i < n; i++) {
            l[i]=scanner.nextInt();
            r[i]=scanner.nextInt();
        }
        long[][]dp=new long[n][2];
        dp[0][0]=2*r[0]-l[0]-1;
        dp[0][1]=r[0]-1;
        for (int i = 1; i < n; i++) {
             dp[i][0]=Math.min(dp[i-1][0]+Math.abs(r[i]-l[i-1])+r[i]-l[i]+1,dp[i-1][1]+Math.abs(r[i]-r[i-1])+r[i]-l[i]+1);
             dp[i][1]=Math.min(dp[i-1][0]+Math.abs(l[i]-l[i-1])+r[i]-l[i]+1,dp[i-1][1]+Math.abs(l[i]-r[i-1])+r[i]-l[i]+1);
        }
        long min=Math.min(dp[n-1][0]+Math.abs(n-l[n-1]),dp[n-1][1]+Math.abs(n-r[n-1]));
        System.out.println(min);
    }
}
