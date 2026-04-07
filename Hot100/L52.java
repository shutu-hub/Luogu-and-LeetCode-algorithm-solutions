package Hot100;

import java.util.LinkedList;

/**
 * 腐烂的橘子
 * 思路：
 */
public class L52 {

    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int[]dx = {1, -1, 0, 0};
        int[]dy = {0,0,1,-1};
        // 创建队列执行广度有限搜索
        LinkedList<Integer> hang = new LinkedList<>();
        LinkedList<Integer> lie = new LinkedList<>();
        // 将已经腐烂的橘子入队
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==2){
                    hang.add(i);
                    lie.add(j);
                    count++;
                }
            }
        }
        // 感染
        int res = 0;
        while (!hang.isEmpty()){
            int num = 0;
            boolean flag = false;
            for (int k = 0; k < count; k++) {
                Integer x = hang.poll();
                Integer y = lie.poll();
                for (int i = 0; i < dx.length; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx>=0 && xx<grid.length && yy>=0 && yy<grid[0].length && grid[xx][yy]==1){
                        hang.add(xx);
                        lie.add(yy);
                        grid[xx][yy]=2;
                        num++;
                        flag = true;
                    }
                }
            }
            count=num;
            if (flag){
                res+=1;
            }
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}
