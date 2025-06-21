package Simulate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array=new int[n+1][n+1];
        // 初始化数组
        int number=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n ; j++) {
                array[i][j]=number++;
            }
        }
        // 改变 m 次矩阵
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();
            int z = scanner.nextInt();

            int[][] temp = new int[n+1][n+1];
            for (int j = x - r; j <= x + r; j++) {
                for (int k = y - r; k <= y + r; k++) {
                    temp[j][k] = array[j][k];
                }
            }
            if (z == 0) {
                int x1 = x + r;
                int y1 = y - r;
                // 2.1 顺时针将行内元素反转
                for (int j = x - r; j <= x + r; j++) {
                    for (int k = y - r; k <= y + r; k++) {
                        // 将一列元素赋值到array对应的一行上
                        array[j][k] = temp[x1][y1];
                        x1--;
                    }
                    x1 = x + r;
                    y1++;
                }
            } else {
                int x1 = x - r;
                int y1 = y + r;
                // 2.1 顺时针将行内元素反转
                for (int j = x - r; j <= x + r; j++) {
                    for (int k = y - r; k <= y + r; k++) {
                        // 将一列元素赋值到array对应的一行上
                        array[j][k] = temp[x1][y1];
                        x1++;
                    }
                    x1 = x - r;
                    y1--;
                }
            }
        }
        for (int i = 1; i< array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
}
}