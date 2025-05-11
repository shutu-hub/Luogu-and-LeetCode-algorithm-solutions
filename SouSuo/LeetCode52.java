package SouSuo;

public class LeetCode52 {
    private static int count;
    private static int[]lie;
    private static int[]youXia;
    private static int[]youShang;

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    public static int totalNQueens(int n) {
            count=0;
            lie=new int[n];
            youXia=new int[2*n];
            youShang=new int[2*n];
            dfs(0,n);
            return count;
    }

    public static void dfs(int row,int n){
        if (row>=n){
            // 搜索结束
            count++;
            return;
        }
        // 每一行可以选择一个数 选择范围为1~n
        for (int i = 0; i < n; i++) {
            if (lie[i]==1 || youXia[row-i+n]==1 || youShang[row+i]==1){
                // 冲突
                continue;
            }
            // i列可以选择
            lie[i]=1;
            youXia[row-i+n]=1;
            youShang[row+i]=1;
            dfs(row+1,n);
            lie[i]=0;
            youXia[row-i+n]=0;
            youShang[row+i]=0;
        }
    }
}
