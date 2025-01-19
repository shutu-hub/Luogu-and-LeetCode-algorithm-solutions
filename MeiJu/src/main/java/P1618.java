import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class P1618 {
    static Scanner scanner=new Scanner(System.in);
    static int A = scanner.nextInt();
    static int B = scanner.nextInt();
    static int C = scanner.nextInt();
    static boolean flags=false;

    public static void main(String[] args) {
        int[]number=new int[10];
        boolean[]flag=new boolean[10];
        // 深度搜索枚举所有情况
        digui(1,number,flag);
        if (!flags){
            System.out.println("No!!!");
        }
    }

    public static int judge(int m,int[] number){
        int sum=0;
        for (int i = 3*m-2; i <=3*m ; i++) {
                int ele=number[i];
                sum=sum*10+ele;
        }
        return sum;
    }


    public static void digui(int index,int[]number, boolean[]flag){
        if (index>=10){
            // 9位数全部使用完了 判断比例关系
            int one=judge(1,number);
            int two=judge(2,number);
            int three=judge(3,number);
           if (one*B==two*A && one*C==three*A && two*C==three*B){
               System.out.print(one+" ");
               System.out.print(two+" ");
               System.out.print(three);
               System.out.println();
               flags=true;
           }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!flag[i]){
                // 拼接这个数
                number[index]=i;
                flag[i]=true;
                digui(index+1,number,flag);
                flag[i]=false;
            }
        }
    }
}
