package SouSuo;
import java.util.Scanner;


public class P2895 {
    public static long result=Integer.MAX_VALUE;
    public static boolean[][]flags;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m = scanner.nextInt();
        int[][]array=new int[302][302];
        // 记录这个点是否是爆炸点
        flags=new boolean[302][302];
        for (int i = 0; i < m; i++) {
            int x =scanner.nextInt();
            int y = scanner.nextInt();
            int time = scanner.nextInt();
            initial(x,y,time,array);
            initial(x-1,y,time,array);
            initial(x+1,y,time,array);
            initial(x,y-1,time,array);
            initial(x,y+1,time,array);
        }
        int[][]time=new int[302][302];
        for (int i = 0; i < time.length; i++) {
            for (int j = 0; j < time.length; j++) {
                time[i][j]=1001;
            }
        }
        dfs(array,0,0,0,time);
        if (result==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    public static void initial(int x,int y,int time,int[][]array){
        if (x<0 || y<0){
            return;
        }
        if (!flags[x][y]){
            flags[x][y]=true;
            array[x][y]=time;
        }else{
            array[x][y]=Math.min(array[x][y],time);
        }
    }

    public static void dfs(int[][]array,int x,int y,int now,int[][]time) {
        if (x<0 || x>array.length-1 || y<0 || y>array.length-1 ){
            // 让x,y指向当前位置
            // 而不是 x-1<0 || x+1>array.length-1 || y-1<0 || y+1>array.length
            return;
        }
        if (array[x][y]!=0 && now>=array[x][y]){
            // 已经被摧毁
            return;
        }
        if (array[x][y]==0 && !flags[x][y]){
            result=Math.min(result,now);
        }
        if (now>=time[x][y]){
            // 走到这里的时间比之前的时间长
            return;
        }
        // 上下左右
        time[x][y]=now;
        dfs(array,x,y+1,now+1,time);
        dfs(array,x,y-1,now+1,time);
        dfs(array,x-1,y,now+1,time);
        dfs(array,x+1,y,now+1,time);
    }
}
