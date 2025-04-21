import java.util.Scanner;

public class P1036 {
    static int count=0;
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array=new int[n];
        int sum=0;
        boolean[] flags=new boolean[n];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
        }
        digui(1,array,k,sum,flags,0);
        System.out.println(count);

    }
    public static void digui(int index,int[]array,int k,int sum,boolean[] flags,int start){
        if (index>k){
            // 已经选择够数量 判断sum是否是素数
            if (isPrime(sum)){
                count++;
            }
            return;
        }
        for (int i = start; i < array.length; i++) {
            if (!flags[i]){
                sum+=array[i];
                flags[i]=true;
                // 这里start是i+1而不是start+1 因为i指向的是当前数 i+1是之后的数
                // start是第一次进入该循环开始的数 之后循环继续而start不变 会造成重复
                digui(index+1,array,k,sum,flags,i+1);
                flags[i]=false;
                sum-=array[i];
            }
        }
    }

    private static boolean isPrime(int sum) {
        for (int i = 2; i <= sum/i; i++) {
            if (sum%i==0){
                // 不是素数
                return false;
            }
        }
        return true;
    }
}
