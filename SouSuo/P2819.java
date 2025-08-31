package SouSuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2819 {
    static int n;
    static int k;
    static int m;
    static int count=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        m=scanner.nextInt();
        List<Edge>edges=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Edge edge= new Edge(scanner.nextInt(), scanner.nextInt());
            edges.add(edge);
        }
        int[]colors=new int[n+1];
        dfs(1,colors,edges);
        System.out.println(count);
    }

    public static void dfs(int num,int[]colors,List<Edge>edges){
        if (num>n){
            for (Edge edge : edges) {
                if (colors[edge.from] == colors[edge.to]) {
                    return;
                }
            }
            count++;
            return;
        }
        for (int i = 1; i <= m; i++) {
               colors[num]=i;
               dfs(num+1,colors,edges);
        }
    }

    static class  Edge{
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
