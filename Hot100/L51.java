package Hot100;

public class L51 {

    int[]dx={1,-1,0,0};
    int[]dy={0,0,-1,1};
    boolean[][]flag;

    public int numIslands(char[][] grid) {
        int count=0;
        flag=new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1' && !flag[i][j]){
                    // 搜索它能到达的陆地，并标记
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        flag[i][j]=true;
        for (int k = 0; k < dx.length; k++) {
            int dx1 = i+dx[k];
            int dy1 = j+dy[k];
            if (dx1>=0 && dx1<grid.length && dy1>=0 && dy1<grid[0].length && !flag[dx1][dy1] && grid[dx1][dy1]=='1'){
                dfs(dx1,dy1,grid);
            }
        }
    }


}
