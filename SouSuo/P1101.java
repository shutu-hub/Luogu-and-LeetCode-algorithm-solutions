package SouSuo;

import java.util.Scanner;

public class P1101 {
    public static int[]dx={-1,1,0,0,1,-1,1,-1};
    public static int[]dy={0,0,-1,1,1,-1,-1,1};
    public static char[]yizhong={'y','i','z','h','o','n','g'};
    public static char[][]array;
    public static boolean[][]isChar;
    public static int n;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        array=new char[n][n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextLine().toCharArray();
        }
        isChar=new boolean[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]=='y'){
                    dfs(i,j);
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isChar[i][j]){
                    System.out.print(array[i][j]);
                }else{
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }

    /**
     * 搜索8个方向
     * @param i
     * @param j
     */
    public static void dfs(int i, int j) {
        for (int k = 0; k < 8 ; k++) {
            int xx= dx[k];
            int yy= dy[k];
            int l;
            for (l= 1; l < 7; l++) {
                // 从当前位置向后找7个字符 判断是否相等
                int xxx = i + xx*l;
                int yyy = j + yy*l;
                if (xxx<0 || xxx>n-1 || yyy<0 || yyy>n-1){
                    break;
                }
                if (array[xxx][yyy]!=yizhong[l]){
                    break;
                }
            }
            if (l==7){
                for (l= 0; l < 7; l++) {
                    int xxx = i + xx*l;
                    int yyy = j + yy*l;
                    isChar[xxx][yyy]=true;
                }
            }
        }
    }
}
