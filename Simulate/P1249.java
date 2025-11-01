package Simulate;

import java.math.BigInteger;
import java.util.Scanner;

public class P1249 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        // 将n拆分成多个数相加 2+3+k<=n 2+3+k+（k+1）> n
        int sum=0;
        // 加到第几个数
        int k=0;
        int[]num=new int[n];
        for (int i = 2; i <=n ; i++) {
            sum+=i;
            if (sum>n){
                sum-=i;
                k=i-1;
                break;
            }
            num[k]=i;
            k++;
        }
        int remain=n-sum;
        // 倒序一一增1
        int addCount=remain/(k-1);
        for (int i = 0; i < addCount ;i++) {
            for (int index=0; index < k-1; index++) {
                num[index]++;
            }
        }
        remain-=addCount*(k-1);
        // 继续倒序自增 直到remain为0
        int index=k-2;
        while (remain>0 && index>=0){
            num[index]++;
            remain--;
            index--;
        }
        BigInteger bigInteger=BigInteger.ONE;
        for (int i = 0; i < k-1; i++) {
            System.out.print(num[i]+" ");
            bigInteger=bigInteger.multiply(new BigInteger(num[i]+""));
        }
        System.out.println();
        System.out.println(bigInteger);
    }
}
