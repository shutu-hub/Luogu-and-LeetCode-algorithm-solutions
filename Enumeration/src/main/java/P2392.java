import java.util.Arrays;
import java.util.Scanner;

public class P2392 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array=new int[4];
        for (int i = 0; i < 4; i++) {
            array[i]=scanner.nextInt();
        }
        int sum=0;
        for (int value : array) {
            // 将时间比作价值
            int[] values = new int[value];
            // 总时间
            int sumTime = 0;
            for (int j = 0; j < values.length; j++) {
                values[j] = scanner.nextInt();
                sumTime += values[j];
            }
            // 比作01背包问题 当左右脑时间最接近t/2时 效率高
            int[][] dp = new int[value][sumTime / 2 + 1];
            for (int j = 0; j < sumTime / 2+1; j++) {
                if (j >= values[0]) {
                    dp[0][j] = values[0];
                }
            }
            for (int j = 1; j < value; j++) {
                for (int k = 0; k < sumTime / 2 + 1; k++) {
                    if (k < values[j]) {
                        dp[j][k] = dp[j - 1][k];
                    } else {
                        dp[j][k] = Math.max(dp[j - 1][k], dp[j - 1][k - values[j]] + values[j]);
                    }
                }
            }
            sum += Math.max(dp[value - 1][sumTime / 2], sumTime - dp[value - 1][sumTime / 2]);
        }
        System.out.println(sum);
    }
}
