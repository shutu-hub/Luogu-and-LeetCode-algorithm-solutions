package SouSuo;

import java.util.LinkedList;
import java.util.Scanner;

public class P1443 {
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][]array=new int[n+1][m+1];
        array[x][y]=0;
        LinkedList<Integer>hangQueue=new LinkedList<>();
        LinkedList<Integer>lieQueue=new LinkedList<>();
        int[]dx={-2,-2,2,2,1,-1,1,-1};
        int[]dy={-1,1,-1,1,2,-2,-2,2};
        hangQueue.offer(x);
        lieQueue.offer(y);
        int number=1;
        int count=0;
        while(!hangQueue.isEmpty()){
            // 记录下一层元素个数
            int geshu=0;
            count++;
            for (int j = 0; j < number; j++) {
                Integer xx = hangQueue.poll();
                Integer yy = lieQueue.poll();
                for (int i = 0; i < 8; i++) {
                    // 8种选择方式
                    int  nextX= xx + dx[i];
                    int nextY = yy + dy[i];
                    if (nextX>=1 && nextX<=n && nextY>=1 && nextY<=m && array[nextX][nextY]==0){
                        // 这个点可以走 步数等于走到这个点的步数+1
                        array[nextX][nextY]=count;
                        hangQueue.offer(nextX);
                        lieQueue.offer(nextY);
                        geshu++;
                    }
                }
            }
            number=geshu;
        }
        array[x][y]=0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j]==0 && (i!=x || j!=y)){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(array[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

}
