package LanQiaoBei;


public class P11_four {

    static long sum=0;
    static int[]f=new int[8];// 并查集 记录每个节点的父亲
    static boolean[]isUse=new boolean[8];

    public static void main(String[] args) {
        // 组合不同长度的二极管 判断是否联通 联通则计数
        // abcdefg
        int[][]adj=new int[8][8];
        adj[1][2]=1;adj[1][6]=1;
        adj[2][1]=1;adj[2][3]=1;adj[2][7]=1;
        adj[3][2]=1;adj[3][7]=1;adj[3][4]=1;
        adj[4][3]=1;adj[4][5]=1;
        adj[5][4]=1;adj[5][6]=1;adj[5][7]=1;
        adj[6][1]=1;adj[6][5]=1;adj[6][7]=1;
        adj[7][2]=1; adj[7][3]=1; adj[7][5]=1; adj[7][6]=1;
        // 深度为7的深度搜索 每个节点都有选择和不选择两种方式 两路递归
        dfs(adj,1);
        System.out.println(sum);
    }

    public static int find(int x){
        if (f[x]==x){
            return x;
        }
        return find(f[x]);
    }

    public static  void dfs(int[][]adj, int index){
        if (index>7){
            // 判断组合是否联通
            // 1 初始化并查集
            for (int i = 1; i <=7 ; i++) {
                f[i]=i;
            }
            for (int i = 1; i <=7 ; i++) {
                for (int j = 1; j <=7 ; j++) {
                    if (adj[i][j]==1 && isUse[i] && isUse[j]){
                        int fx = find(i);
                        int fy = find(j);
                        if (fx==fy){
                            // 同为一个父亲 不需要合并
                            continue;
                        }else{
                            // 合并
                            f[fx]=fy;
                        }
                    }
                }
            }
            int count=0;
            for (int i = 1; i <=7 ; i++) {
                if (isUse[i] && f[i]==i){
                    count++;
                }
            }
            if (count==1)sum++;
            return;
        }
        // 选择该节点
        isUse[index]=true;
        dfs(adj,index+1);
        // 不选择该节点
        isUse[index]=false;
        dfs(adj,index+1);
    }
}
