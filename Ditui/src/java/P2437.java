package Ditui.src.java;

import java.math.BigInteger;
import java.util.Scanner;

public class P2437 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        BigInteger[]dp=new BigInteger[n-m+1];
        dp[0]=BigInteger.ONE;
        dp[1]=BigInteger.ONE;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-2].add(dp[i-1]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
