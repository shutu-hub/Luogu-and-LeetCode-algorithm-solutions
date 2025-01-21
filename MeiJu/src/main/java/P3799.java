import java.util.Scanner;

public class P3799 {
    static double mod = Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n];
        int[]counts=new int[n];
        // 记录最大长度
        int maxLength=0;
        int menLength=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
            counts[array[i]]++;
            maxLength=Math.max(maxLength,array[i]);
            menLength=Math.min(menLength,array[i]);
        }
        int count=0;
        // 外层循环 拿到两个长度为i值木棒 i和j是长度 counts.length是有多少种长度不同的元素 无法代表最长长度
        for (int i = menLength+1; i <= maxLength; i++) {
            // 排列组合的方式 在长度等于i的木棒中挑两个
            if (counts[i]<2){
                continue;
            }
            int a=C(counts[i],2);
            // 内层循环 拿到两根长度和为i的木棒
            for (int j = menLength; j <= i/2; j++) {
                int c;
                // 两根木棒相等 则总长度为j的木棒中挑2个
                if (j==i-j){
                    if (counts[j]<2){
                        continue;
                    }
                    c=C(counts[j],2);
                }else{
                    // 两根木棒长度相等 则总长度为j的木棒中挑1个 i-j的木棒中挑一个
                    c=C(counts[j],1)*C(counts[i-j],1);
                }
                count+=a*c;
                count %= (int) mod;
            }
        }
        System.out.println(count);;
    }

    public static int C(int  n,int k){
        if (k==2){
            // 从n个数中取2个数
            return n*(n-1)/2;
        }else{
            return n;
        }
    }
}
