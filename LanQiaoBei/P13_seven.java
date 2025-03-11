package LanQiaoBei;

import java.util.Scanner;

public class P13_seven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
        }

        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {  // i 是子数组的终点
            int max = array[i];
            int min = array[i];
            for (int j = i; j >= 1; j--) {  // 从终点 i 向左遍历起点 j
                max = Math.max(max, array[j]);
                min = Math.min(min, array[j]);
                if (max - min == i - j) {   // 子数组 j~i 有效
                    dp[i] = (dp[i] + dp[j - 1]) % mod;
                }
            }
        }

        System.out.println(dp[n] % mod);
    }
}