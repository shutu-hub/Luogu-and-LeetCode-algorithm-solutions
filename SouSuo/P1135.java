package SouSuo;
import java.util.Scanner;

public class P1135 {
    public static long result=Integer.MAX_VALUE;
    public static int b;
    public static int n;
    public static int a;

    /**
     * 上3 下2 上3
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        // 每层的数字
        int[]array=new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i]=scanner.nextInt();
        }
        int[]minBuShu=new int[n+1];
        for (int i = 1; i <= n; i++) {
            minBuShu[i]=Integer.MAX_VALUE;
        }
        dfs(array,a,0,minBuShu);
        if (result==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    public static void dfs(int[] array,int num,int count,int[]minBuShu){
            if (num>n || num<1){
                // 既无法上楼 也无法下楼
                return;
            }
            if (count>=minBuShu[num]){
                // 如果这个点到达过 判断此次到达是否比之前的步数长
                return;
            }
            if (count>=result){
                // 走到这里时步数 >= 之前到达最终点的步数
                return;
            }
            if (num==b){
                //记录一次答案
                result=count;
                return ;
            }
            // 更新到达这个点的最小步数
            minBuShu[num]=count;
            dfs(array,num+array[num],count+1,minBuShu);
            dfs(array,num-array[num],count+1,minBuShu);
    }
}
