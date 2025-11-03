package TuLun;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long[][]adj=new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j]=scanner.nextInt();
            }
        }
        // 使用prim算法获得最小生成树
        // 用来判断该点是否在最小生成树中
        boolean[]vis=new boolean[n];
        // to weight
        long sum=0;
        PriorityQueue<long[]>queue=new PriorityQueue<>(Comparator.comparingLong(longs -> longs[1]));
        queue.offer(new long[]{0,0});
        while (!queue.isEmpty()){
            long[] poll = queue.poll();
            int point = (int)poll[0];
            if (vis[point]){
                continue;
            }
            sum+=poll[1];
            vis[point]=true;
            // 遍历point的邻接点
            for (int i = 0; i < n; i++) {
                if (adj[point][i]!=Integer.MAX_VALUE && !vis[i]){
                   queue.offer(new long[]{i,adj[point][i]});
                }
            }
        }
        System.out.println(sum);
    }

}
