package TuLun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class P4779 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n =(int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        st.nextToken();
        int s = (int)st.nval;
        List<edge>[]graphs=new List[n+1];
        for (int i = 0; i < graphs.length; i++) {
            graphs[i]=new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            st.nextToken();
            int u = (int)st.nval;
            st.nextToken();
            int v = (int)st.nval;
            st.nextToken();
            long w = (int)st.nval;
            graphs[u].add(new edge(v,w));
        }
        long[]dis=new long[n+1];
        for (int i = 1; i <= n; i++) {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[s]=0;
       PriorityQueue<long[]>queue=new PriorityQueue<>(Comparator.comparingLong(longs -> longs[1]));
       // 到哪个节点，距离
       queue.add(new long[]{s,0});
       boolean[]visited=new boolean[n+1];
       while (!queue.isEmpty()){
           long[] arr = queue.poll();
           int node = (int)arr[0];
           long curDis = arr[1];

           if (visited[node])continue;
           visited[node]=true;

           // 遍历该节点的邻接点 然后更新start到其邻接点的距离
           for (edge edge : graphs[node]) {
               int nextNode = edge.to;
               long nextDis = edge.weight;
               if (dis[nextNode]>curDis+nextDis){
                   dis[nextNode]=curDis+nextDis;
                   queue.offer(new long[]{nextNode,dis[nextNode]});
               }
           }
       }
        for (int i = 1; i <=n ; i++) {
            System.out.print(dis[i]+" ");
        }
    }

    public static class edge{
        int to;
        long weight;

        public edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
