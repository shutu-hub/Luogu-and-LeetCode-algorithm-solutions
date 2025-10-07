package LanQiaoBei.P10;

import java.util.Arrays;
import java.util.Scanner;

public class P8682 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long[]number=new long[n];
        for (int i = 0; i < n; i++) {
            number[i]=scanner.nextInt();
        }
        // 找到所有数的最大公约数
        Arrays.sort(number);
        // 找到所有公差d的倍数(相邻数的差) 求他们的最大公约数
        long[]diff=new long[n];
        for (int i = 1; i <= n-1; i++) {
            long a = number[i-1];
            long b = number[i];
            diff[i]=b-a;
        }
        long d = diff[1];
        for (int i = 1; i <= n-2; i++) {
            long a = diff[i];
            long b = diff[i+1];
            long gcd = gcd(a, b);
            d=Math.min(d,gcd);
        }
        long size = 0;
        if (d==0){
            size=n;
        }else{
             size=(number[n-1]-number[0])/d+1;
        }
        System.out.println(size);
    }

    public static long gcd(long a,long b){
        while (b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
