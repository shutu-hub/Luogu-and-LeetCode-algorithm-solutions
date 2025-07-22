import java.util.Scanner;

public class P2036 {
    static int result=Integer.MAX_VALUE;
    static boolean flag=false;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array=new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        int s=1;
        int b=0;
        boolean[]flags=new boolean[n];
        // n次深度搜索 每次深度不同
        dfs(array,0,flags,s,b);
        System.out.println(result);
    }

    public static void dfs(int[][]array,int start,boolean[]flags,int s,int b){
        if (flag){
            int abs = Math.abs(s - b);
            if (abs<result){
                result=abs;
            }
        }

        for (int i = start; i <array.length ; i++) {
            if (!flags[i]){
                s*=array[i][0];
                b+=array[i][1];
                flags[i]=true;
                flag = true;
                dfs(array,i+1,flags,s,b);
                flags[i]=false;
                s/=array[i][0];
                b-=array[i][1];
            }
        }
    }
}
