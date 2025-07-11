package Prefix;

import java.util.Scanner;

public class P1719 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][]array=new int[n+1][n+1];
        int[][]prefix=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                array[i][j]=scanner.nextInt();
                prefix[i][j]=prefix[i][j-1]+prefix[i-1][j]-prefix[i-1][j-1]+array[i][j];
            }
        }
        long max=Integer.MIN_VALUE;
        // x1,y1模拟左上角 x2,y2模拟右下角
        for (int x1 = 1; x1 <=n ; x1++) {
            for (int y1 = 1; y1 <=n ; y1++) {
//                右下角的x，y坐标必须大于左上角的x，y坐标
                for (int x2 = x1; x2 <=n ; x2++) {
                    for (int y2 = y1; y2 <=n ; y2++) {
                        int number = prefix[x2][y2]-prefix[x2][y1-1]-prefix[x1-1][y2]+prefix[x1-1][y1-1];
                        if (number>max){
                            max=number;
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }
}
