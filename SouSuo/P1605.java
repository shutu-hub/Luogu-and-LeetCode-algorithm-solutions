package SouSuo;

import java.util.Scanner;

public class P1605 {
    public static int n;
    public static int m;
    public static int sx;
    public static int sy;
    public static int fx;
    public static int fy;
    public static int count;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int t = scanner.nextInt();
        sx = scanner.nextInt();
        sy = scanner.nextInt();
        fx = scanner.nextInt();
        fy = scanner.nextInt();
        int[][] array=new int[n+1][m+1];
        for (int i = 0; i < t; i++) {
            // 障碍点
            array[scanner.nextInt()][scanner.nextInt()]=-1;
        }
        boolean[][]flags=new boolean[n+1][m+1];
        dfs(array,flags,sx,sy);
        System.out.println(count);
    }

    public static void dfs(int[][] array,boolean[][]flags,int x,int y){
        if (x<=0 || y<=0 || x>n ||y>m){
            return;
        }
        if (array[x][y]==-1){
            // 这个点是障碍点
            return;
        }
        if (x==fx && y==fy){
            count+=1;
            return;
        }
        if (flags[x][y]){
            return;
        }
        flags[x][y]=true;
        dfs(array,flags,x+1,y);
        dfs(array,flags,x-1,y);
        dfs(array,flags,x,y+1);
        dfs(array,flags,x,y-1);
        // 这个点上下左右都走完了 回溯到上一个点 把这个点放掉
        flags[x][y]=false;
    }
}
