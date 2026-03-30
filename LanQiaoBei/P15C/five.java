package LanQiaoBei.P15C;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 最小生成树：
 * 将n个节点通过n-1条边连接起来，并且使边权和最小
 * Prim算法核心思想：先选取一个点，然后将该点所有的邻接点加入到队列中，每次从队列中弹出一个边距离最小的点
 * 每次处理一个点时，要判断这个点是否已经处理过
 * 向队列中添加的元素类型为数组，[到达哪个点，到达这个点的距离]
 * 所以每次弹出的元素为在所有可以到达的候选点中距离最小的一个点
 */
public class five {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.next();
        }
        int[][] adj = new int[n][n];
        // 1 计算每两个字符串之间的最长公共子串
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                adj[i][j]=getLCS(arr[i],arr[j]);
                adj[j][i]=getLCS(arr[i],arr[j]);
            }
        }
        // 2 构建最小生成树(边权和最大)
        // 从一个点触发
        int sum=0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        queue.offer(new int[]{0,0});
        boolean[] isVisited = new boolean[n];
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int point = poll[0];
            if (isVisited[point]){
                continue;
            }
            isVisited[point]=true;
            sum+=poll[1];
            // 将该点的所有邻接点加入队列
            for (int i = 0; i < n; i++) {
                if (adj[point][i]!=0 && !isVisited[i]){
                    queue.offer(new int[]{i,adj[point][i]});
                }
            }
        }
        System.out.println(sum);
    }

    public static int getLCS(String a,String b){
        int m = a.length();
        a=a+a;
        b=b+b;
        int[][]dp = new int[a.length()+1][b.length()+1];
        int maxLenth=0;
        for (int i = 1; i <=a.length(); i++) {
            for (int j = 1; j <= b.length() ; j++) {
                if (a.charAt(i-1) ==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxLenth=Math.max(maxLenth,dp[i][j]);
                }
            }
        }
        return Math.min(maxLenth,m);
    }
}
