package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class P4017 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        int m=(int)st.nval;
        long[]dp=new long[n+1];
        // 邻接表 记录每个动物可以被谁吃
        ArrayList<Integer>[] predators=new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            predators[i]=new ArrayList();
        }
        int[]inDegree=new int[n+1];
        int[]outDegree=new int[n+1];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int eaten=(int)st.nval;
            st.nextToken();
            int eat=(int)st.nval;
            predators[eaten].add(eat);
            inDegree[eat]++;
            outDegree[eaten]++;
        }
        LinkedList<Integer>queues=new LinkedList<>();
        // 将所有入度为0的生产者放入队列中
        for (int i = 1; i <inDegree.length ; i++) {
            if (inDegree[i]==0){
                dp[i]=1;
                queues.offer(i);
            }
        }
        while(!queues.isEmpty()){
            Integer eaten = queues.poll();
            for (int o : predators[eaten]) {
                 dp[o]=(dp[o]+dp[eaten])%80112002;
                 inDegree[o]--;
                 if (inDegree[o]==0){
                     queues.offer(o);
                 }
            }
        }
        long count=0;
        for (int i = 1; i <outDegree.length ; i++) {
            if (outDegree[i]==0){
                // 出度为0 顶级消费者
                count=(count+dp[i])%80112002;
            }
        }
        System.out.println(count%80112002);
    }

//    public static long dfs(long[]dp,int[][]adj,int target,int n){
//        if (dp[target]!=0){
//            return dp[target];
//        }
//        // 搜索target可以有多少条
//        for (int i = 1; i <= n; i++) {
//            if (adj[target][i]!=0){
//                long count = dfs(dp, adj, i, n);
//                if (count==0){
//                    dp[target]=(dp[target]+1)%80112002;
//                }else{
//                    dp[target]=(dp[target]+count)%80112002;
//                }
//            }
//        }
//        return dp[target];
//    }
}
