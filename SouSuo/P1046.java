package SouSuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;

public class P1046 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        streamTokenizer.nextToken();
        int n = (int)streamTokenizer.nval;
        streamTokenizer.nextToken();
        int m = (int)streamTokenizer.nval;
        streamTokenizer.nextToken();
        int q = (int)streamTokenizer.nval;
        int[][]adj=new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            streamTokenizer.nextToken();
            int ai = (int)streamTokenizer.nval;
            streamTokenizer.nextToken();
            int bi = (int)streamTokenizer.nval;
            adj[ai][bi]=1;
            adj[bi][ai]=1;
        }

        // BFS
        long sum=0;
        for (int i = 0; i < q; i++) {
            streamTokenizer.nextToken();
            int start = (int)streamTokenizer.nval;
            streamTokenizer.nextToken();
            int y = (int)streamTokenizer.nval;

            int[] distance=new int[n+1];
            Arrays.fill(distance,Integer.MAX_VALUE);
            distance[start]=0;
            boolean[]visited=new boolean[n+1];
            visited[start]=true;

            // 从start开始搜索
            LinkedList<Integer>queues=new LinkedList<>();
            queues.offer(start);

            while (!queues.isEmpty()){
                Integer x = queues.poll();
                // 将它的邻接点放进队列里 是下一层元素
                if (distance[x]==y){
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (adj[x][j]==1 && !visited[j]){
                        distance[j]=distance[x]+1;
                        visited[j]=true;
                        queues.offer(j);
                    }
                }
            }
            int cnt=0;
            for (int j = 1; j <= n; j++) {
                if (distance[j]<=y)cnt++;
            }
            sum+=cnt;
        }
        System.out.printf("%.2f",(double)sum/q);
    }
}
