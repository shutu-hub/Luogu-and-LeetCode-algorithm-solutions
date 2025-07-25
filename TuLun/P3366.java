package TuLun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class P3366 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;

        ArrayList<Edge>graph=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int x = (int)st.nval;
            st.nextToken();
            int y = (int)st.nval;
            st.nextToken();
            int weight =(int)st.nval;
            graph.add(new Edge(x,y,weight));
        }
        PriorityQueue<Edge>queue=new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        queue.addAll(graph);
        int[]x=new int[n+1];
        for (int i = 0; i <= n; i++) {
            x[i]=i;
        }
        long sum=0;
        int k=0;
        while (!queue.isEmpty()){
            Edge poll = queue.poll();
            int start = poll.start;
            int end = poll.to;
            int weight = poll.weight;
            // 是将父亲合并 而不是start的父类指向end
            int faStart = find(start, x);
            int faEnd = find(end, x);
            if (faStart!=faEnd){
                sum+=weight;
                x[faStart]=faEnd;
                k++;
            }
            if (k==n-1){
                break;
            }
        }
        if (k==n-1){
            System.out.println(sum);
        }else{
            System.out.println("orz");
        }
    }

    public static int find(int x,int[]xi){
        if (xi[x]==x){
            return x;
        }
        return find(xi[x],xi);
    }
}

class Edge{
    int start;
    int to;
    int weight;

    public Edge(int start,int to, int weight) {
        this.start=start;
        this.to = to;
        this.weight = weight;
    }
}