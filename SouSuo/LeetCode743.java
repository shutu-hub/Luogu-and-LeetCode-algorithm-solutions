package SouSuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1.初始化邻接矩阵
        int[][]adj=new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (i!=j){
                    adj[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times[i].length; j++) {
                int start = times[i][0];
                int end = times[i][1];
                int weight = times[i][2];
                adj[start][end]=weight;
            }
        }
        int[]dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]>queue=new PriorityQueue<>(Comparator.comparingInt(ints -> ints[1]));
        queue.add(new int[]{k,0});
        boolean[]isVisited=new boolean[n+1];
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int start = poll[0];
            isVisited[start]=true;
            for (int i = 1; i < adj[start].length ; i++) {
                if (adj[start][i]==Integer.MAX_VALUE || isVisited[i]){
                    continue;
                }
                if (dis[start]+adj[start][i]<dis[i]){
                    dis[i]=dis[start]+adj[start][i];
                    queue.add(new int[]{i,dis[i]});
                }
            }
        }
        int max=-1;
        for (int i = 1; i < dis.length; i++) {
            if (dis[i]==Integer.MAX_VALUE){
                // 存在到达不了的点
                return -1;
            }
            max= Math.max(max,dis[i]);
        }
        return max;
    }
}
