package Simulate;

import java.math.BigInteger;
import java.util.Scanner;

public class P1998 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        // 计算1的阶乘-n的阶乘的和
        BigInteger sum=new BigInteger("0");
        BigInteger tempSum=new BigInteger("1");
        for (int i=1; i<=n; i++) {
            tempSum= tempSum.multiply(new BigInteger(i+""));
            sum=sum.add(tempSum);
        }
        System.out.println(sum);
    }

}






