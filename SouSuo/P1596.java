package SouSuo;

import java.util.Scanner;

public class P1596 {
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    // 判断这个点是否已经染过色
    static boolean[][]flags;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][]array=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j]=scanner.nextInt();
                if (array[i][j]==0){
                    // 将所有0染色为2
                    array[i][j]=2;
                }
            }
        }
        flags=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (array[0][i]==2){
                search(0,i,array,n);// 第一行
            }
            if (array[n-1][i]==2){
                search(n-1,i,array,n);// 最后一行
            }
            if (array[i][0]==2){
                search(i,0,array,n);// 第一列
            }
            if (array[i][n-1]==2){
                search(i,n-1,array,n);// 最后一列
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j]==0){
                    System.out.print(0+" ");
                }else {
                    System.out.print(array[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void search(int i,int j,int[][] array,int n){
        if (i<0 || j<0 || i>=n || j>=n){
            return;
        }
        if (flags[i][j]){
            // 这个点已经染过色 返回
            return;
        }
        if (array[i][j]==1){
            return;
        }
        if (array[i][j]==2){
            array[i][j]=0;
        }
        // 这个点可以联通 并且不是1 染色
        flags[i][j]=true;
        for (int k = 0; k < 4; k++) {
            int xx = dx[k];
            int yy=dy[k];
            search(i+xx,j+yy,array,n);
        }
    }
}
