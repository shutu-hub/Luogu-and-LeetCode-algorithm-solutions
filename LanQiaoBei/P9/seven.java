package LanQiaoBei.P9;

import java.io.IOException;
import java.util.Scanner;

public class seven {
    public static int[]dx={0,0,1,-1};
    public static int[]dy={1,-1,0,0};
    public static long count=0;
    public static long cir_count_temp=0;
    public static long cir_count=0;
    public static char[][]array;
    public static int n;
    public static boolean[][]visited=new boolean[n][n];

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        array=new char[n][n];
        visited=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            array[i]= scanner.next().toCharArray();
        }

        // 1.找到岛屿的个数（连通的陆地）
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (array[i][j]=='#' && !visited[i][j]){
                    cir_count_temp=0;
                    count+=dfs(i,j);
                    if (cir_count_temp>0){
                        cir_count++;
                    }
                }
            }
        }
        System.out.println(count-cir_count);
    }

    public static int dfs(int x, int y) {
        visited[x][y]=true;
        // 判断该点是否是上下左右都是# 不会被淹没
        boolean flag=true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx<0 || yy<0 || xx>=n || yy>=n){
                continue;
            }
            if (array[xx][yy]=='.'){
                flag=false;
                break;
            }
        }
        if (flag){
            cir_count_temp++;
        }

        // 把它连通的都标记 则在本次dfs中形成一个岛屿 下次在main方法的for循环再碰到这个岛屿的陆地时
        // visited[i][i]已经为1 则不会再把这个陆地当作一个新的岛屿
        for (int k = 0; k < 4; k++) {
            int xx = x + dx[k];
            int yy = y + dy[k];
            // 搜索该陆地连通的陆地
            if (xx<0 || yy<0 || xx>=n || yy>=n){
                continue;
            }
            if (array[xx][yy]=='#' && !visited[xx][yy]){
                dfs(xx,yy);
            }
        }
        return 1;
    }
}
