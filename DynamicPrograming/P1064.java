package DynamicPrograming;

import java.util.Scanner;

public class P1064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[m + 1][3];
        int[][] follows = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            array[i][0] = scanner.nextInt(); // 价格
            array[i][1] = scanner.nextInt(); // 重要度
            int follow = scanner.nextInt();
            if (follow != 0) {
                if (follows[follow][0] == 0) {
                    follows[follow][0] = i;
                } else {
                    follows[follow][1] = i;
                }
                array[i][2] = 1; // 标记为附件
            }
        }
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            if (array[i][2] != 0) { // 处理附件
                System.arraycopy(dp[i - 1], 0, dp[i], 0, n + 1);
                continue;
            }
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j]; // 初始化为不购买当前主件
                if (j >= array[i][0]) {
                    int price = array[i][0];
                    int importance = array[i][1];
                    int f1 = follows[i][0];
                    int f2 = follows[i][1];

                    // 情况1：仅主件
                    long v1 = dp[i - 1][j - price] + (long) price * importance;

                    // 情况2：主件 + 附件1
                    long v2 = 0;
                    if (f1 != 0 && j >= price + array[f1][0]) {
                        v2 = dp[i - 1][j - price - array[f1][0]]
                                + (long) price * importance
                                + (long) array[f1][0] * array[f1][1];
                    }

                    // 情况3：主件 + 附件2
                    long v3 = 0;
                    if (f2 != 0 && j >= price + array[f2][0]) {
                        v3 = dp[i - 1][j - price - array[f2][0]]
                                + (long) price * importance
                                + (long) array[f2][0] * array[f2][1];
                    }

                    // 情况4：主件 + 附件1 + 附件2
                    long v4 = 0;
                    if (f1 != 0 && f2 != 0 && j >= price + array[f1][0] + array[f2][0]) {
                        v4 = dp[i - 1][j - price - array[f1][0] - array[f2][0]]
                                + (long) price * importance
                                + (long) array[f1][0] * array[f1][1]
                                + (long) array[f2][0] * array[f2][1];
                    }

                    // 取所有情况的最大值，并与不购买的情况比较
                    long currentMax = Math.max(Math.max(v1, v2), Math.max(v3, v4));
                    dp[i][j] = Math.max(dp[i][j], currentMax);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}