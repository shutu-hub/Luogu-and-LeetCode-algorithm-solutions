package LanQiaoBei.P10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class four {
    public static int[]dx={0,0,1,-1};
    public static int[]dy={1,-1,0,0};
    static long min=Integer.MAX_VALUE;
    static String[] chars={"R","L","D","U"};
    public static ArrayList<String> path=new ArrayList<>();
    static int[][]minBuShu=new int[30][50];
    public static StringBuilder result=new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[][]array=new int[30][50];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 30; i++) {
            String str = scanner.next();
            for (int j = 0; j < 50; j++) {
                array[i][j]=Integer.parseInt(str.charAt(j)+"");
            }
        }
        for (int[] ints : minBuShu) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        dfs(array,0,0,0);
        System.out.println(result.toString());
    }

    public static void dfs(int[][] array,int x,int y,int count){
        if (x<0 || x>=30 || y<0 || y>=50 || array[x][y]==1) {
           return;
        }
        if (x==29 && y==49){
            if (count<min){
                // 更新当前路径
                min=count;
                result=new StringBuilder();
                for (String s : path) {
                    result.append(s);
                }
            }else if (count==min){
                // 选择字典序最小的
                for (int i = 0; i <path.size() ; i++) {
                    char now=path.get(i).charAt(0);
                    if (now<result.charAt(i)){
                        result=new StringBuilder();
                        for (String s : path) {
                            result.append(s);
                        }
                        return;
                    }
                }
            }
            return;
        }
        if (count>minBuShu[x][y]){
            return;
        }
        minBuShu[x][y]=count;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            path.add(chars[i]);
            dfs(array,xx,yy,count+1);
            path.remove(chars[i]);
        }
    }
}
