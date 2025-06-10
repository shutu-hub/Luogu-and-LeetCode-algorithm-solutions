import java.util.Arrays;
import java.util.Scanner;

public class P1088 {
    static int count=0;
    static int[]array;
    static int M;
    static int target;
    static boolean flag=false;

    public static void main(String[] args) {
        new Thread(null, () -> {
            Scanner scanner=new Scanner(System.in);
            int N = scanner.nextInt();
            M = scanner.nextInt();
            // array是火星人的手指
            array=new int[N];
            for (int i = 0; i < N; i++) {
                array[i]=scanner.nextInt();
            }
            // 1.将手指转为所代表的数字
            boolean[] flags=new boolean[N+1];
            int[]num=new int[N];
            // 2.加上小整数
            // 3.转为手指数
            digui(1,flags,N,num);
            scanner.close();
        },"t",2<<24).start();

    }

    /**
     * 全排列
     * @return
     */
    public static void digui(int index,boolean[]flags,int N,int[]num)  {
        if (index>N){
            count++;
            if (count==1){
                // 第一次找到的排列数 皆为输入的数
                // 计算目标值
                target=count+M;
            }
            if (count==target){
                for (int ele : num) {
                    System.out.print(ele+" ");
                }
                flag=true;
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (count==0){
                // count==0 还没有找到第一个排列的数
                // array是给定的数组 1 2 3 4 5 多次递归之后 直接到达给定的位置
                i=array[index-1];
            }
            if (!flags[i]){
                num[index-1]=i;
                flags[i]=true;
                digui(index+1,flags,N,num);
                flags[i]=false;
                if (flag){
                    // 结束
                    System.exit(0);
                }
            }
        }
    }
}
