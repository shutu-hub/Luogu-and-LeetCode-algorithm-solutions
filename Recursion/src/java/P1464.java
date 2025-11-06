package Recursion.src.java;

import java.util.Scanner;

public class P1464 {
   static long[][][] array=new long[21][21][21];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            if (a == -1 && b == -1 && c == -1){
                break;
            }
            long w = w(a, b, c);
            System.out.println("w("+a+", "+b+", "+c+") = "+w);
        }
    }

    public static long w(long a,long b,long c){
        if (a<=0 || b<=0 || c<=0){
            return 1;
        }
        if (a>20 || b>20 || c>20){
            if (array[20][20][20]==0){
                array[20][20][20]= w(20,20,20);
            }
            return array[20][20][20];
        }
        int d=(int)a;
        int e=(int)b;
        int f=(int)c;
        if (a<b && b<c){
            if(array[d][e][f-1]==0){
                array[d][e][f-1]=w(d,e,f-1);
            }
            if (array[d][e-1][f-1]==0){
                array[d][e-1][f-1]=w(d,e-1,f-1);
            }
            if (array[d][e-1][f]==0)   {
                array[d][e-1][f]=w(d,e-1,f);
            }
            array[d][e][f]= array[d][e][f-1]+array[d][e-1][f-1]-array[d][e-1][f];
        }else{
            if (array[d-1][e][f]==0){
                array[d-1][e][f]=w(d-1,e,f);
            }
            if (array[d-1][e-1][f]==0){
                array[d-1][e-1][f]=w(d-1,e-1,f);
            }
            if (array[d-1][e][f-1]==0){
                array[d-1][e][f-1]=w(d-1,e,f-1);
            }
            if (array[d-1][e-1][f-1]==0){
                array[d-1][e-1][f-1]=w(d-1,e-1,f-1);
            }
            array[d][e][f]= array[d-1][e][f]+array[d-1][e-1][f]+array[d-1][e][f-1]-array[d-1][e-1][f-1];
        }
        return array[d][e][f];
    }
}
