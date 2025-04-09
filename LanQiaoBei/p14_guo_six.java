package LanQiaoBei;

import java.util.Scanner;

public class p14_guo_six {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]ai=new int[n+1];
        for (int i = 1; i <= n; i++) {
            ai[i]=scanner.nextInt();
        }
        long count=0;
        for (int i = 1; i <=n ; i++) {
            int a = ai[i];
            if (i%a==0){
                // 第一个元素可以被a整除 该列元素均可以被a整除
                count+=n;
            }else{
                // 第一个元素不能被a整除 要在这列中找到a和i的最小公倍数
                // 然后计算这列中有多少这个最小公倍数的倍数
                count+=(long)i*n/lcm(a,i);
            }
        }
        System.out.println(count);
    }

    private static long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }

    private static long gcd(long a,long b){
        while (b!=0){
            long tmp=b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}
