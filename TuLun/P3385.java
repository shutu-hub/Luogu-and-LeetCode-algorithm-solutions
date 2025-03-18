package TuLun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3385 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int t = (int) st.nval;
        for (int i = 0; i < t; i++) {
            st.nextToken();
            int n= (int) st.nval;
            st.nextToken();
            int m= (int) st.nval;
            List<Edge>[]graphs=new List[n+1];
            for (int j = 1; j <=n ; j++) {
                graphs[j]=new ArrayList<>();
            }
            for (int j = 0; j < m; j++) {
                st.nextToken();
                int u= (int) st.nval;
                st.nextToken();
                int v= (int) st.nval;
                st.nextToken();
                int w= (int) st.nval;
                if (w>=0){
                    graphs[u].add(new Edge(v,w));
                    graphs[v].add(new Edge(u,w));
                }else{
                    graphs[u].add(new Edge(v,w));
                }
            }
            long[]dis=new long[n+1];
            Arrays.fill(dis,Integer.MAX_VALUE);
            dis[1]=0;
            for (int j = 0; j < n-1; j++) {
                for (int k = 1; k <=n; k++) {
                    for (Edge edge : graphs[k]) {
                        int nextNode = edge.to;
                        long nextDis=edge.weight;
                        if (dis[k]!=Integer.MAX_VALUE  && dis[nextNode]>dis[k]+nextDis){
                            dis[nextNode]=dis[k]+nextDis;
                        }
                    }
                }
            }
            boolean flag=false;
            for (int k = 1; k <=n; k++) {
                for (Edge edge : graphs[k]) {
                    int nextNode = edge.to;
                    long nextDis=edge.weight;
                    if (dis[k]!=Integer.MAX_VALUE && dis[nextNode]>dis[k]+nextDis){
                        flag=true;
                        break;
                    }
                }
                if (flag)break;
            }
            if (flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
    public static class Edge{
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
