package DynamicPrograming;

import java.util.Scanner;

/**
 *  给定长度为 n 的 ov 串，保证只由 o和 v 两种字符构成，至多选择k个位置改变字符从o到v；v到o，问最多可以产生多少个不相交的 "ovo" 子串。
 */
public class ovo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        for (int m = 0; m < t; m++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String str = scanner.next();
            if (n<3){
                System.out.println(0);
                continue;
            }
            str = " " + str;
            char[] chars = str.toCharArray();
            // 使用dp[i][j]来表示第i个位置第j次修改时 最多可以产生的的 ovo子串
            long[][]dp=new long[n+1][k+1];
            dp[0][0] = dp[1][0] = dp[2][0] = 0;
            for (int i = 3; i <= n; i++) {
                // 从当前字符开始修改 应耗费的次数
                int cost=0;
                if (chars[i]!='o')cost++;
                if (chars[i-1]!='v')cost++;
                if (chars[i-2]!='o')cost++;
                dp[i] = dp[i - 1];
                for (int j = cost; j <= k; j++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-3][j-cost]+1);
                }
            }
            long max=-1;
            for (int i = 1; i <=k ; i++) {
                if (dp[n][i]>max){
                    max=dp[n][i];
                }
            }
            System.out.println(max);
        }

    }
}
