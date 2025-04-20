package LanQiaoBei;

import java.util.Scanner;

public class P15_six {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[][]xingqiu=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j) xingqiu[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            // 初始化距离为1
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            xingqiu[start][end]=1;
            xingqiu[end][start]=1;
        }
        double sum=0;
        floyd(n,xingqiu);
        for (int i = 0; i < q; i++) {
            int start = scanner.nextInt()-1;
            int count = scanner.nextInt();
            int can=0;
            for (int j = 0; j < n; j++) {
                if (xingqiu[start][j]<=count){
                    can++;
                }
            }
            sum+=can;
        }
        System.out.printf("%.2f",sum/q);
    }

    public static void floyd(int n,int[][]xingqiu){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (xingqiu[j][i]!=Integer.MAX_VALUE && xingqiu[i][k]!=Integer.MAX_VALUE && xingqiu[j][i]+xingqiu[i][k]<xingqiu[j][k]){
                        xingqiu[j][k]=xingqiu[j][i]+xingqiu[i][k];
                    }
                }
            }
        }
    }
}
