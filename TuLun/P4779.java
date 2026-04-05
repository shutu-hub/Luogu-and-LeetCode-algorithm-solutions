package TuLun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


public class P4779 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        st.nextToken();
        int s = (int) st.nval;
        List<Edge>[] graphs = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int ui = (int) st.nval;
            st.nextToken();
            int vi = (int) st.nval;
            st.nextToken();
            int wi = (int) st.nval;
            graphs[ui].add(new Edge(vi,wi));
        }
        long[]dis = new long[n+1];
        for (int i = 0; i < dis.length; i++) {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[s]=0;
        // 默认小顶堆，反过来大顶堆
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1, o2) -> (int) (o1[1]-o2[1]));
        queue.add(new long[]{s,0});
        boolean[]flag = new boolean[n+1];
        while (!queue.isEmpty()){
            long[] poll = queue.poll();
            int nextNode = (int) poll[0];
            int nextDis = (int) poll[1];
            if (flag[nextNode]){
                continue;
            }
            flag[nextNode]=true;
            for (int i = 0; i < graphs[nextNode].size(); i++) {
                Edge edge = graphs[nextNode].get(i);
                if (dis[edge.to]>nextDis+edge.weight){
                    // 更新
                    dis[edge.to]=nextDis+edge.weight;
                    queue.offer(new long[]{edge.to,dis[edge.to]});
                }
            }
        }
        for (int i = 1; i <= n ; i++) {
            System.out.print(dis[i]+" ");
        }
    }

    static class Edge {
        int to;
        long weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }



}
