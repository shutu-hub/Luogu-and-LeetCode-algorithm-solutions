package LanQiaoBei.P10;

import java.util.LinkedList;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][]array=new int[30][50];
        for (int i = 0; i < 30; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < 50; j++) {
                array[i][j]=str.charAt(j)-'0';
            }
        }
        // BFS 第一次走到出口时就是最短路径
        // 找到字典序最小的路径 即根据字典序进行广度优先搜索
        int[]dx={1,0,0,-1};
        int[]dy={0,-1,1,0};
        boolean[][]isVisited=new boolean[30][50];
        LinkedList<Point>queue=new LinkedList<>();
        Point start = new Point(0, 0,"");
        queue.add(start);
        String[]chars={"D","L","R","U"};
        while (!queue.isEmpty()){
            Point poll = queue.poll();
            int x=poll.x;
            int y=poll.y;
            if (x==29 && y==49){
                // 出口
                System.out.println(poll.path);
            }
            if (isVisited[x][y]){
                continue;
            }
            isVisited[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx<0||xx>=30||yy<0||yy>=50 || array[xx][yy]==1){
                    continue;
                }
                Point point = new Point(xx, yy,poll.path+chars[i]);
                queue.add(point);
            }
        }


    }
    public static class Point {
        int x;
        int y;
        String path;
        public Point(int x, int y, String path) {
            this.x=x;
            this.y=y;
            this.path=path;
        }
    }
}
