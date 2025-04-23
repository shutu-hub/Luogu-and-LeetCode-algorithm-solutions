package Recursion.src.java;

import java.util.Scanner;

public class P1002 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        // 为避免越界 偏移2行2列
        x+=2;y+=2;a+=2;b+=2;
        // 题目中（0，0）开始 偏移1行1列
        long[][]array=new long[x+1][y+1];

        // 将马能到达的地方初始化
        boolean[][] flags=new boolean[30][30];
        flags[a-2][b-1]=true;
        flags[a-2][b+1]=true;
        flags[a-1][b-2]=true;
        flags[a-1][b+2]=true;
        flags[a+1][b-2]=true;
        flags[a+1][b+2]=true;
        flags[a+2][b-1]=true;
        flags[a+2][b+1]=true;
        flags[a][b]=true;

        // 在进入时使array[2][2]=array[2][1]+array[1][2]=1+0=1
        array[2][1]=1;
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
               if (!flags[i][j]){
                   array[i][j]=array[i-1][j]+array[i][j-1];
               }
            }
        }
        System.out.println(array[x][y]);
    }
}
