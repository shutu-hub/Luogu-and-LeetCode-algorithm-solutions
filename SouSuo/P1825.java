package SouSuo;

import java.util.LinkedList;
import java.util.Scanner;

public class P1825 {
    public static int nextX;
    public static int nextY;
    public static int[][] visited;
    public static char[][] array;
    public static int n;
    public static int m;
    public static int updateNx;
    public static int updateNy;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
       array = new char[n][m];
        int startX = -1, startY = -1;

        // 读取输入并找到起点
        for (int i = 0; i < n; i++) {
            array[i] = scanner.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (array[i][j] == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        LinkedList<Integer> hangQueue = new LinkedList<>();
        LinkedList<Integer> lieQueue = new LinkedList<>();
        hangQueue.offer(startX);
        lieQueue.offer(startY);
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;

        while (!hangQueue.isEmpty()) {
            int size = hangQueue.size();
            for (int k = 0; k < size; k++) {
                int xx = hangQueue.poll();
                int yy = lieQueue.poll();

                if (array[xx][yy] == '=') {
                    System.out.println(count);
                    return;
                }
                // 修改后的处理传送门逻辑
                if (array[xx][yy] >= 'A' && array[xx][yy] <= 'Z') {
                    boolean isUpdate = go(xx, yy);
                    if (isUpdate){
                        xx=updateNx;
                        yy=updateNy;
                    }
                }
                // 处理四个方向
                for (int i = 0; i < 4; i++) {
                    nextX= xx + dx[i];
                    nextY = yy + dy[i];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && array[nextX][nextY] != '#' && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        hangQueue.offer(nextX);
                        lieQueue.offer(nextY);
                    }
                }
            }
            count++; // 只有正常移动才增加步数
        }
    }
    public static boolean go(int nx,int ny){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (array[i][j] == array[nx][ny] && (i != nx || j != ny)) {
                        updateNx=i;
                        updateNy=j;
                        return true;
                    }
                }
            }
            return false;
        }
    }

