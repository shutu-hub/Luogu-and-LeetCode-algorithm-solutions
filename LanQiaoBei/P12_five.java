package LanQiaoBei;

import java.util.*;

public class P12_five {
    public static void main(String[] args) {
        int n=2021;
        List<Edge>[] graphs=new List[2022];
        for (int i = 1; i <=2021 ; i++) {
            graphs[i]=new ArrayList<>();
            for (int j = 1; j <=2021 ; j++) {
                if (Math.abs(i-j)<=21){
                    graphs[i].add(new Edge(j,lcm(i,j)));
                }
            }
        }
        long[]dis=new long[2022];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1]=0;
        boolean[]visited=new boolean[2022];
        PriorityQueue<long[]>queues=new PriorityQueue<>(Comparator.comparingLong(ints -> ints[1]));
        queues.add(new long[]{1,0});
        while (!queues.isEmpty()){
            long[] poll = queues.poll();
            int cur = (int)poll[0];
            long curDis = poll[1];
            if (visited[cur])continue;
            visited[cur]=true;
            for (int i = 0; i < graphs[cur].size(); i++) {
                Edge edge = graphs[cur].get(i);
                int nextNode = edge.to;
                long nextWeight = edge.weight;
                if (dis[nextNode]>curDis+nextWeight){
                    dis[nextNode]=curDis+nextWeight;
                    queues.add(new long[]{nextNode,dis[nextNode]});
                }
            }
        }
        System.out.println(dis[2021]);
    }

    public static long gcd(int i,int j){
        while (j!=0){
            int temp=j;
            j=i%j;
            i=temp;
        }
        return i;
    }

    public static long lcm(int i,int j){
        return Math.abs(i*j)/gcd(i,j);
    }

    public static class Edge{
        int to;
        long weight;
        public Edge(int to, long weight){
            this.to=to;
            this.weight=weight;
        }
    }


}
