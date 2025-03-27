package DynamicPrograming;
import java.util.Scanner;

public class P1802 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[][]array=new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            array[i][0]=scanner.nextInt();
            array[i][1]=scanner.nextInt();
            array[i][2]=scanner.nextInt();
        }
        long[][]dp=new long[n+1][x+1];
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j < dp[i].length ; j++) {
                if (j>=array[i][2]){
                    // 有足够的药剂 可以选择胜利或者失败 选一个更好情况
                    // 因为每一个i都记录了1-x在多种情况下可以得到的最大值，所以i选择打败或者胜利都可以计算出此时可以拿到的最大值，然后选择较好的
                    dp[i][j]=Math.max(dp[i-1][j]+array[i][0],dp[i-1][j-array[i][2]]+array[i][1]);
                }else{
                    dp[i][j]=dp[i-1][j]+array[i][0];
                }
              }
        }
        System.out.println(dp[n][x]*5);
    }
}

