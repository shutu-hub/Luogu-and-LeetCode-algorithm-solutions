package SouSuo;

public class LeetCode200 {

    static int[]dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int count=0;
    public int numIslands(char[][] grid) {
        if (grid[0].length==0){
            return 0;
        }
        boolean[][]isVisited=new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1' && !isVisited[i][j]){
                    dfs(grid,i,j,isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public  void dfs(char[][] grid,int x,int y,boolean[][]isVisited){
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || isVisited[x][y]){
            return ;
        }
        if (grid[x][y]=='0'){
            return;
        }
        isVisited[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int xx=x+dx[i];
            int yy=y+dy[i];
            dfs(grid,xx,yy,isVisited);
        }
    }
}
