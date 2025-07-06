package Recursion.src.java;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger a=new BigInteger("1");
        BigInteger b=new BigInteger("2");
        int i=3;
        BigInteger c = BigInteger.ONE;
        if (n==1){
            System.out.println(1);
        }else if (n==2){
            System.out.println(2);
        } else{
            while (i<=n) {
                c=a.add(b);
                a=b;
                b=c;
                i++;
            }
            System.out.println(c);
        }

    }
}
