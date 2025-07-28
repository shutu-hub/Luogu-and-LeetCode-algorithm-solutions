package Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P3397 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        streamTokenizer.nextToken();
        int n = (int) streamTokenizer.nval;
        streamTokenizer.nextToken();
        int m =  (int) streamTokenizer.nval;
        int[][]array=new int[n+2][n+2];
        int[][]flags=new int[n+2][n+2];
        for (int i = 0; i < m; i++) {
            streamTokenizer.nextToken();
            int x1=(int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int y1=(int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int x2=(int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int y2=(int) streamTokenizer.nval;

            // 差分打标记
            for (int j = x1; j <=x2 ; j++) {
                // 将起点打标记+1 该点之后的数据都是使用flags的和标记的 所有值都会+1
                flags[j][y1]++;
                // 因为有终点 终点之后的数据不应该也变化 所以在终点之后打个补丁 让其--
                flags[j][y2+1]--;
            }
        }
        int sum=0;
        for (int i = 1; i <=n+1 ; i++) {
            for (int j = 1; j <=n+1 ; j++) {
                // 统计标记的和
                sum+=flags[i][j];
                // 标记和即为该值
                array[i][j]=sum;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
