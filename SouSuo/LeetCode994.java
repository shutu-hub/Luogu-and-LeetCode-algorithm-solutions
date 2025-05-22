package SouSuo;

import java.util.LinkedList;

public class LeetCode994 {
    public static void main(String[] args) {
        // [[2,1,1],[1,1,0],[0,1,1]]
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public static int orangesRotting(int[][] grid) {
        int[]dx={1,-1,0,0};
        int[]dy={0,0,1,-1};
        LinkedList<Integer>hangQueue=new LinkedList<>();
        LinkedList<Integer>lieQueue=new LinkedList<>();
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==2){
                    // 腐烂的橘子则入队
                    hangQueue.add(i);
                    lieQueue.add(j);
                    count++;
                }
            }
        }
        int time=0;
        while (!hangQueue.isEmpty()){
            int num=0;
            for (int k = 0; k < count; k++) {
                Integer x = hangQueue.poll();
                Integer y = lieQueue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (nextX<0 || nextY<0 || nextX>=grid.length || nextY>=grid[0].length){
                        // 索引越界违法
                        continue;
                    }
                    if (grid[nextX][nextY]==0 || grid[nextX][nextY]==2){
                        // 空格子 或 已腐烂
                        continue;
                    }
                    // 新鲜橘子入队
                    grid[nextX][nextY]=2;
                    hangQueue.add(nextX);
                    lieQueue.add(nextY);
                    num++;
                }
            }
            count=num;
            if (count!=0){
                time++;
            }
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
