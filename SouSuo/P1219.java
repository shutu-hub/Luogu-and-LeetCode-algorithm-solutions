package SouSuo;
import java.util.Scanner;

public class P1219 {
    public static int count=0;
    public static int n;
    // 记录每行存储的列下标
    static int[]a;
    // 记录哪一列被使用
    static int[]b;
   // 左下到右上对角线
    static int[]c;
    // 左上到右下对角线
    static int[]d;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        a=new int[n+1];
        b=new int[n];
        c=new int[2*n];
        d=new int[2*n];
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int index){
        if (index>n){
            if (count<3){
                for (int i = 1; i <=n ; i++) {
                    System.out.print(a[i]+" ");
                }
                System.out.println();
            }
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 第i列未使用 该位置的左下到右上的对角线行+列固定值位index+i
            if (b[i]==0 && c[index+i]==0 && d[i-index+n]==0){
                b[i]=1;c[index+i]=1;d[i-index+n]=1;
                // index是行号 i是列
                a[index]=i+1;
                dfs(index+1);
                b[i]=0;c[index+i]=0;d[i-index+n]=0;
            }
        }
    }
}
