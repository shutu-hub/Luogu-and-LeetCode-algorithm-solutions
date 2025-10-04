package Hot100;

import java.util.LinkedList;

public class L52 {

    public int orangesRotting(int[][] grid) {
        // 每次出队是过去了一分钟，出队的次数等于经过的最小分钟数
        // 广度优先搜索
        int[]dx = {1,-1,0,0};
        int[]dy = {0,0,1,-1};
        LinkedList<Integer> hangQueue = new LinkedList<>();
        LinkedList<Integer> lieQueue = new LinkedList<>();
        // 第一次遍历，将腐烂的橘子入队
        int count = 0;
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==2){
                    hangQueue.offer(i);
                    lieQueue.offer(j);
                    count++;
                }else if (grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if (freshCount == 0){
            return 0;
        }
        int time = 0;
        // 当最后一次感染之后，若没有了新鲜橘子，即使又有新的橘子入队，也不需要遍历了，所以最后的time不需要-1了
        while (!hangQueue.isEmpty() && freshCount>0){
            int nextCount = 0;
            for (int k = 0; k < count; k++) {
                Integer x = hangQueue.poll();
                Integer y = lieQueue.poll();
                // 寻找可以感染的橘子
                for (int i = 0; i < dx.length; i++) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx>=0 && xx<grid.length && yy>=0 && yy<grid[0].length && grid[xx][yy]==1){
                        hangQueue.offer(xx);
                        lieQueue.offer(yy);
                        grid[xx][yy]=2;
                        freshCount--;
                        nextCount++;
                    }
                }
            }
            count = nextCount;
            time++;
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
