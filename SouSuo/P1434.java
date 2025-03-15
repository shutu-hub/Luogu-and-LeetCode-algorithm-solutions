package SouSuo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1434 {
    public static int r;
    public static int c;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={-1,1,0,0};
    public static int maxCount=-1;
    public static class point{
        int x;
        int y;
        int height;
        point(int x,int y,int height){
            this.x=x;
            this.y=y;
            this.height=height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        int[][]array=new int[r][c];
        ArrayList<point>points=new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j]=scanner.nextInt();
                points.add(new point(i,j,array[i][j]));
            }
        }
        points.sort(Comparator.comparingInt(point -> point.height));
        int[][]dp=new int[r][c];
        for (int i = 0; i < points.size(); i++) {
            point point = points.get(i);
            // 上下左右四个方向
            int x = point.x;int y = point.y;
            dp[x][y]=1;
            for (int j = 0; j <= 3; j++) {
                int xx = dx[j] + x;
                int yy = dy[j] + y;
                if (xx<0 || yy<0 || xx>=r || yy>=c || array[x][y]<=array[xx][yy])continue;
                dp[x][y]=Math.max(dp[x][y],dp[xx][yy]+1);
            }
            maxCount=Math.max(maxCount,dp[x][y]);
        }
        System.out.println(maxCount);
    }


//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        r = scanner.nextInt();
//        c = scanner.nextInt();
//        int[][]array=new int[r][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                array[i][j]=scanner.nextInt();
//            }
//        }
//        // 每个点出发可以到达的最大距离
////        int[][]maxLength=new int[r][c];
////        for (int i = 0; i < r; i++) {
////            for (int j = 0; j < c; j++) {
////                dfs(i,j,array,maxLength);
////            }
////        }
//        System.out.println(maxCount);
//    }

//    public static int dfs(int x,int y,int[][]array,int[][]maxLength){
//        if (maxLength[x][y]!=0){
//            // 从这个点出发的最大路径已经计算过
//            return maxLength[x][y];
//        }
//        // 初始化为距离为1 即起点
//        maxLength[x][y]=1;
//        for (int i = 0; i < 4; i++) {
//            int xx=x+dx[i];
//            int yy=y+dy[i];
//            if (xx<0 || xx>=r || yy<0 || yy>=c || array[xx][yy]>=array[x][y] ){
//               continue;
//            }
//            int length = dfs(xx, yy, array, maxLength);
//            maxLength[x][y]= Math.max(maxLength[x][y],length+1);
//        }
//        maxCount=Math.max(maxLength[x][y],maxCount);
//        return maxLength[x][y];
//    }
}
